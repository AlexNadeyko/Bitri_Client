package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame implements NotifierChangeViewApp {

        private int width = 800;
        private int height = 800;

        private JPanel panelMain;
        private JPanel panelTop;

        private List observers;
        private ViewResources.TypeOfPanel typeOfView;

        private Controller controller;


        public MainFrame(){
            observers = new ArrayList();
            initUI();
        }


    private void initUI(){

        setSize(width, height);

        panelTop = new PanelTitleBar(this);
        panelMain = new PanelLogo();

        add(BorderLayout.NORTH, panelTop);
        add(BorderLayout.CENTER, panelMain);

        List<Image> listOfIcons = new ArrayList<Image>();
        listOfIcons.add(new ImageIcon(getClass().getClassLoader().getResource("logo_icon_20px.png")).getImage());
        listOfIcons.add(new ImageIcon(getClass().getClassLoader().getResource("logo_icon_40px.png")).getImage());
        setIconImages(listOfIcons);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);


//            graphEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT,streamFontFile));
        try {
            GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("BellMTBold.ttf")));
            graphEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("BellMT.ttf")));

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        changePanel(new PanelWelcome(this));
    }


    public void changePanel(JPanel panel){
        remove(panelMain);
        panelMain = panel;
        add(panelMain);
        revalidate();
        determineTypeOfView(panelMain);
        notifyObserver();

    }

    private void determineTypeOfView(JPanel panelMain) {
        if (panelMain instanceof PanelWelcome) {
            typeOfView = ViewResources.TypeOfPanel.PANEL_WELCOME;
        } else if (panelMain instanceof PanelSignUp) {
            typeOfView = ViewResources.TypeOfPanel.PANEL_SIGN_UP;
        }else if (panelMain instanceof PanelLogin){
            typeOfView = ViewResources.TypeOfPanel.PANEL_LOGIN;
        }

    }

    @Override
    public void addObserver(ObserverChangeViewApp observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverChangeViewApp observer) {
        if (observers.indexOf(observer) >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            ObserverChangeViewApp observer = (ObserverChangeViewApp) observers.get(i);
            observer.update(typeOfView);
        }
    }

    public JPanel getPanelMain(){
            return panelMain;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
