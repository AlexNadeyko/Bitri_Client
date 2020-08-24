package Views;

import javax.swing.*;
import java.awt.*;

public class PanelLogo extends JPanel {

    JLabel labelLogo;

    public PanelLogo(){
        initUI();
    }

    private void initUI(){
        setLayout(new BorderLayout());
        setBackground(new Color(48,50,55));

        labelLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("logo_main.png")));
        add(BorderLayout.CENTER, labelLogo);
    }

}
