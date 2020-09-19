package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PanelLogin extends JPanel {

    private MainFrame frame;
    private SpringLayout layout;

    private JLabel labelTitle;
    private JLabel labelLogin;
    private JTextField textLogin;
    private JLabel labelPassword;
    private JPasswordField textPassword;
    private JButton btnSubmit;
    private JButton btnReturn;


    public PanelLogin(MainFrame frame){
        this.frame = frame;
        initUI();
    }


    private void initUI(){
        setBackground(ViewResources.COLOR_BACKGROUND);
        layout = new SpringLayout();
        setLayout(layout);


        btnReturn = new JButton();
        btnReturn.setPreferredSize(new Dimension(50,50));
        btnReturn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_return_default.png")));
        btnReturn.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_return_rollover.png")));
        btnReturn.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_return_pressed.png")));

        btnReturn.setContentAreaFilled(false);
        btnReturn.setBorder(null);
        btnReturn.setBorderPainted(false);
        btnReturn.setOpaque(false);

        btnReturn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.changePanel(new PanelWelcome(frame));
            }
        });


        labelTitle = new JLabel("Login");
        labelTitle.setForeground(ViewResources.COLOR_VIOLET);
        labelTitle.setFont(ViewResources.getFontBellMtBold());


        labelLogin = new JLabel("Login");
        labelLogin.setForeground(ViewResources.COLOR_VIOLET);
        labelLogin.setFont(ViewResources.getFontBellMtBold().deriveFont(25f));


        textLogin = new JTextField();
        textLogin.setPreferredSize(new Dimension(600, 40));
        textLogin.setFont(ViewResources.getFontBellMt().deriveFont(25f));
        textLogin.setBackground(ViewResources.COLOR_TEXT_FIELD);
        textLogin.setForeground(ViewResources.COLOR_VIOLET);
        textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
        textLogin.setCaretColor(ViewResources.COLOR_VIOLET );

        textLogin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_VIOLET ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textLogin.getText().length() == 0){
                    textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
                }
            }
        });


        labelPassword = new JLabel("Password");
        labelPassword.setForeground(ViewResources.COLOR_VIOLET);
        labelPassword.setFont(ViewResources.getFontBellMtBold().deriveFont(25f));


        textPassword = new JPasswordField();
        textPassword.setPreferredSize(new Dimension(600, 40));
        textPassword.setFont(ViewResources.getFontBellMt().deriveFont(30f));
        textPassword.setBackground(ViewResources.COLOR_TEXT_FIELD);
        textPassword.setForeground(ViewResources.COLOR_VIOLET);
        textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
        textPassword.setCaretColor(ViewResources.COLOR_VIOLET);

        textPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_VIOLET ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textPassword.getText().length() == 0){
                    textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
                }
            }
        });

        btnSubmit = new JButton();
        btnSubmit.setPreferredSize(new Dimension(609, 67));
        btnSubmit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_submit_default.png")));
        btnSubmit.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_submit_rollover.png")));
        btnSubmit.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_submit_pressed.png")));
        btnSubmit.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_submit_disabled.png")));


        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setBorder(null);
        btnSubmit.setBorderPainted(false);
        btnSubmit.setOpaque(false);


        Controller controller = frame.getController();
        btnSubmit.addActionListener(controller.new BtnSubmitLoginPanelListener());


        add(btnReturn);
        layout.putConstraint(SpringLayout.NORTH, btnReturn, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, btnReturn, 10, SpringLayout.WEST, this);

        add(labelTitle);
        layout.putConstraint(SpringLayout.NORTH, labelTitle, 20, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST, labelTitle, 330, SpringLayout.WEST,this);

        add(labelLogin);
        layout.putConstraint(SpringLayout.NORTH, labelLogin, 120, SpringLayout.NORTH, labelTitle);
        layout.putConstraint(SpringLayout.WEST, labelLogin, 100, SpringLayout.WEST, this);

        add(textLogin);
        layout.putConstraint(SpringLayout.NORTH, textLogin, 40, SpringLayout.NORTH, labelLogin);
        layout.putConstraint(SpringLayout.WEST, textLogin, 100, SpringLayout.WEST, this);

        add(labelPassword);
        layout.putConstraint(SpringLayout.NORTH, labelPassword, 80, SpringLayout.NORTH, textLogin);
        layout.putConstraint(SpringLayout.WEST, labelPassword, 100, SpringLayout.WEST, this);

        add(textPassword);
        layout.putConstraint(SpringLayout.NORTH, textPassword, 40, SpringLayout.NORTH, labelPassword);
        layout.putConstraint(SpringLayout.WEST, textPassword, 100, SpringLayout.WEST, this);

        add(btnSubmit);
        layout.putConstraint(SpringLayout.NORTH, btnSubmit, 100, SpringLayout.NORTH, textPassword);
        layout.putConstraint(SpringLayout.WEST, btnSubmit, 100, SpringLayout.WEST, this);
    }


    public String[] getUserData() {
        String[] userData = new String[2];
        userData[0] = textLogin.getText();
        userData[1] = textPassword.getText();
        return userData;
    }
}
