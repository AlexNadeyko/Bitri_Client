package Controllers;

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
           new Thread(clientWorkerSystemSignUp).start();
       }
   }


    @Override
    public void update(ViewResources.TypeOfPanel typeOfPanel) {
        typeOfPanelViewApp = typeOfPanel;
    }
}
