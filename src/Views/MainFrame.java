package Views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame {

        private int width = 800;
        private int height = 800;

        private JPanel panelMain;
        private JPanel panelTop;


        public MainFrame(){
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

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

}
