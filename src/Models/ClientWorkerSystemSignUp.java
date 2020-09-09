package Models;

import MessagesClientServer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientWorkerSystemSignUp implements Runnable {

    private Socket socketServer;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private String[] userData;


    public ClientWorkerSystemSignUp(String[] userData){
        this.userData = userData;
        configureComunication();
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
    }


}
