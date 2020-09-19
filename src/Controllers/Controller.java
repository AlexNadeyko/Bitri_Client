package Controllers;

import MessagesClientServer.InnerMessage;
import MessagesClientServer.InnerMessageSystemOperationResult;
import Models.ClientWorkerSystemLogin;
import Models.ClientWorkerSystemSignUp;
import Views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ObserverChangeViewApp {

    private MainFrame mainFrame;
    //private PanelLogin panelLogin;
    //private PanelSignUp panelSignUp;
    //private PanelWelcome panelWelcome;
    private ViewResources.TypeOfPanel typeOfPanelViewApp;


   public Controller(MainFrame mainFrame){
       this.mainFrame = mainFrame;
       ((NotifierChangeViewApp) this.mainFrame).addObserver(this);
   }


   public class BtnSubmitSignUpPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PanelSignUp panelSignUp = (PanelSignUp) mainFrame.getPanelMain();
            String[] userData;
            userData = panelSignUp.getUserData();
            ClientWorkerSystemSignUp clientWorkerSystemSignUp = new ClientWorkerSystemSignUp(userData);
            clientWorkerSystemSignUp.addObserver(new ControllerSignUpListener());
            new Thread(clientWorkerSystemSignUp).start();
        }
    }

    public class BtnSubmitLoginPanelListener implements ActionListener{

       @Override
        public void actionPerformed(ActionEvent e) {
            PanelLogin panelLogin = (PanelLogin) mainFrame.getPanelMain();
            String[] userData;
            userData = panelLogin.getUserData();
            ClientWorkerSystemLogin clientWorkerSystemLogin = new ClientWorkerSystemLogin(userData);
            clientWorkerSystemLogin.addObserver(new ControllerLoginListener());
            new Thread(clientWorkerSystemLogin).start();
        }
    }



    public class ControllerSignUpListener implements ObserverClientWorker {

        @Override
        public void update(InnerMessage innerMessage) {
            InnerMessageSystemOperationResult innerMessageServerResponse =
                    (InnerMessageSystemOperationResult) innerMessage;

            boolean answer = innerMessageServerResponse.getAnswer();
            String description = innerMessageServerResponse.getDescription();

            if (answer){
                mainFrame.displayInfoDialog(description, ViewResources.ColorOfTextDialog.POSITIVE);
                PanelSignUp panelSignUp = (PanelSignUp) mainFrame.getPanelMain();
                panelSignUp.setAllFieldsEmpty();
            }else{
                mainFrame.displayInfoDialog(description, ViewResources.ColorOfTextDialog.NEGATIVE);
            }
        }
    }

    public class ControllerLoginListener implements ObserverClientWorker{

        @Override
        public void update(InnerMessage innerMessage) {
            InnerMessageSystemOperationResult innerMessageServerResponse =
                    (InnerMessageSystemOperationResult) innerMessage;

            boolean answer = innerMessageServerResponse.getAnswer();
            String description = innerMessageServerResponse.getDescription();

            if (answer){
                mainFrame.dispose();
                //
                System.out.println("!!!there must opens new jframe");
                //
            }else {
                mainFrame.displayInfoDialog(description, ViewResources.ColorOfTextDialog.NEGATIVE);
            }
        }
    }


    @Override
    public void update(ViewResources.TypeOfPanel typeOfPanel) {
        typeOfPanelViewApp = typeOfPanel;
    }
}
