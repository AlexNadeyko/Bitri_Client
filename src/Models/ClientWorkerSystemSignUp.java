package Models;

import Controllers.NotifierClientWorker;
import Controllers.ObserverClientWorker;
import MessagesClientServer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientWorkerSystemSignUp implements Runnable, NotifierClientWorker {

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

    @Override
    public void run() {
        sendUserData();
        InnerMessageSystemOperationResult innerMessageServerResponse = waitResponseServer();
        notifyObserver(innerMessageServerResponse);

    }

    private void sendUserData(){

        try {
            InnerMessage innerMessage = new InnerMessageSystemAddUserSignUp(userData);
            BasicMessage basicMessage = new BasicMessage(TypeOfInnerMessage.ADD_USER_SIGN_UP, innerMessage);
            objectOutputStream.writeObject(basicMessage);
            objectOutputStream.flush();
            //
            System.out.println("***Client/ClientWorkerSystemSignUp: send user's data to server***");
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InnerMessageSystemOperationResult waitResponseServer() {

        InnerMessageSystemOperationResult innerMessage = null;

        try {
            ObjectInputStream objectInputStream  = new ObjectInputStream(socketServer.getInputStream());
            BasicMessage basicMessage = (BasicMessage) objectInputStream.readObject();
            innerMessage = (InnerMessageSystemOperationResult) basicMessage.getInnerMessage();
            System.out.println("***Client/ClientWorkerSystemSignUp: get response from server***");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return innerMessage;
    }


    @Override
    public void addObserver(ObserverClientWorker observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverClientWorker observer) {
        if (observers.indexOf(observer) >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(InnerMessage innerMessage) {
        for (int i = 0; i < observers.size(); i++) {
            ObserverClientWorker observer = (ObserverClientWorker) observers.get(i);
            observer.update(innerMessage);
        }
    }
}
