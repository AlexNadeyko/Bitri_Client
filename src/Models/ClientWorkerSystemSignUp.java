package Models;

import Controllers.NotifierSignUp;
import Controllers.ObserverSignUp;
import MessagesClientServer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientWorkerSystemSignUp implements Runnable, NotifierSignUp {

    private Socket socketServer;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private String[] userData;

    private List observers;


    public ClientWorkerSystemSignUp(String[] userData){
        this.userData = userData;
        configureComunication();

        observers = new ArrayList();
    }


    private void configureComunication() {

        try {
            socketServer = new Socket(ClientResources.SERVER_IP, ClientResources.PORT);
            objectOutputStream = new ObjectOutputStream(socketServer.getOutputStream());
            //objectInputStream = new ObjectInputStream(socketServer.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    private void sendUserData(){

        try {
            InnerMessage innerMessage = new InnerMessageSystemAddUserSignUp(userData);
            BasicMessage basicMessage = new BasicMessage(TypeOfInnerMessage.ADD_USER_SIGN_UP, innerMessage);
            objectOutputStream.writeObject(basicMessage);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        sendUserData();
        InnerMessageSystemOperationResult innerMessageServerResponse = waitResponseServer();
        notifyObserver(innerMessageServerResponse);

    }

    private InnerMessageSystemOperationResult waitResponseServer() {

        InnerMessageSystemOperationResult innerMessage = null;

        try {
            ObjectInputStream objectInputStream  = new ObjectInputStream(socketServer.getInputStream());
            BasicMessage basicMessage = (BasicMessage) objectInputStream.readObject();
            innerMessage = (InnerMessageSystemOperationResult) basicMessage.getInnerMessage();
            System.out.println("***Client: get response from server / sign up operation***");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return innerMessage;
    }


    @Override
    public void addObserver(ObserverSignUp observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverSignUp observer) {
        if (observers.indexOf(observer) >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(InnerMessage innerMessage) {
        for (int i = 0; i < observers.size(); i++) {
            ObserverSignUp observer = (ObserverSignUp) observers.get(i);
            observer.update(innerMessage);
        }
    }
}
