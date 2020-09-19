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

public class ClientWorkerSystemLogin implements Runnable, NotifierClientWorker {

    private List observers;
    private String[] userData;
    private ObjectOutputStream outputStreamServer;
    private Socket socketServer;

    public ClientWorkerSystemLogin(String[] userData) {
        this.userData = userData;
        configureComunication();

        observers = new ArrayList();
    }

    private void configureComunication() {
        try {
            socketServer = new Socket(ClientResources.SERVER_IP, ClientResources.PORT);
            outputStreamServer = new ObjectOutputStream(socketServer.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


    @Override
    public void run() {
        sendUserData();
        InnerMessage innerMessage = waitResponseServer();
        notifyObserver(innerMessage);
    }

    private void sendUserData() {
        try {
            InnerMessage innerMessage = new InnerMessageSystemExistUserLogin(userData);
            BasicMessage basicMessage = new BasicMessage(TypeOfInnerMessage.EXIST_USER_LOGIN, innerMessage);
            outputStreamServer.writeObject(basicMessage);
            outputStreamServer.flush();
            //
            System.out.println("***Client/ClientWorkerSystemLogin: send user's data to server***");
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InnerMessage waitResponseServer() {
            InnerMessage innerMessage = null;
        try {
            ObjectInputStream inputStreamServer = new ObjectInputStream(socketServer.getInputStream());
            BasicMessage basicMessage = (BasicMessage) inputStreamServer.readObject();
            innerMessage = basicMessage.getInnerMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //
        System.out.println("***Client/ClientWorkerSystemLogin: get response from server***");
        //
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
        for(int i = 0; i < observers.size(); i++){
            ObserverClientWorker observerClientWorker = (ObserverClientWorker) observers.get(i);
            observerClientWorker.update(innerMessage);
        }
    }
}
