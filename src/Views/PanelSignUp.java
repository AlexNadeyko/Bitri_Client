package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.InputStream;

public class PanelSignUp extends JPanel {

    private SpringLayout layout;

    private MainFrame frame;

    private JLabel labelTitle;
    private JLabel labelName;
    private JLabel labelSurname;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JLabel labelPasswordConfirm;
    private JTextField textName;
    private JTextField textSurname;
    private JTextField textLogin;
    private JPasswordField textPassword;
    private JPasswordField textPasswordConfirm;
    private JButton btnSubmit;
    private JButton btnReturn;

    private Font fontBellMTBold;
    private Font fontBellMT;

    private Color colorViolet;
    private Color colorTextField;
    private Color colorTextFieldBorder;

    public PanelSignUp(MainFrame frame)
    {
        this.frame = frame;
        initUI();
    }


    private void initUI(){
        setBackground(new Color(48,50,55));
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


        try {
            InputStream streamFontFile = getClass().getClassLoader().getResourceAsStream("BellMTBold.ttf");
            fontBellMTBold = Font.createFont(Font.TRUETYPE_FONT, streamFontFile).deriveFont(45f);
            InputStream streamFontFile1 = getClass().getClassLoader().getResourceAsStream("BellMT.ttf");
            fontBellMT = Font.createFont(Font.TRUETYPE_FONT, streamFontFile1);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        colorViolet = new Color(170, 51, 255);
        colorTextField = new Color(63,65,72);
        colorTextFieldBorder = new Color(87,90,100);


        labelTitle = new JLabel("Sign Up");
        labelTitle.setFont(fontBellMTBold);
        labelTitle.setForeground(colorViolet);


        labelName = new JLabel("Name");
        labelName.setFont(fontBellMTBold.deriveFont(25f));
        labelName.setForeground(colorViolet);


        textName = new JTextField();
        textName.setPreferredSize(new Dimension(600, 40));
        textName.setFont(fontBellMT.deriveFont(25f));
        textName.setBackground(colorTextField);
        textName.setForeground(colorViolet);
        textName.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
        textName.setCaretColor(colorViolet);


        labelSurname = new JLabel("Surname");
        labelSurname.setFont(fontBellMTBold.deriveFont(25f));
        labelSurname.setForeground(colorViolet);


        textSurname = new JTextField();
        textSurname.setPreferredSize(new Dimension(600, 40));
        textSurname.setFont(fontBellMT.deriveFont(25f));
        textSurname.setBackground(colorTextField);
        textSurname.setForeground(colorViolet);
        textSurname.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
        textSurname.setCaretColor(colorViolet);


        labelLogin = new JLabel("Login");
        labelLogin.setFont(fontBellMTBold.deriveFont(25f));
        labelLogin.setForeground(colorViolet);


        textLogin = new JTextField();
        textLogin.setPreferredSize(new Dimension(600, 40));
        textLogin.setFont(fontBellMT.deriveFont(25f));
        textLogin.setBackground(colorTextField);
        textLogin.setForeground(colorViolet);
        textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
        textLogin.setCaretColor(colorViolet);

        /*textUsername.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textUsername.getText() != null || textUsername.getText() != ""){
                    textUsername.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
                }
                else{
                    textUsername.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });*/

        textName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textName.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textName.getText().length() == 0){
                    System.out.println("null");
                    textName.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
                }
            }
        });


        textSurname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textSurname.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textSurname.getText().length() == 0){
                    System.out.println("null");
                    textSurname.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
                }
            }
        });


        textLogin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textLogin.getText().length() == 0){
                    System.out.println("null");
                    textLogin.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
                }
            }
        });



        labelPassword = new JLabel("Password");
        labelPassword.setForeground(colorViolet);
        labelPassword.setFont(fontBellMTBold.deriveFont(25f));


        textPassword = new JPasswordField();
        textPassword.setPreferredSize(new Dimension(600, 40));
        textPassword.setFont(fontBellMT.deriveFont(30f));
        textPassword.setBackground(colorTextField);
        textPassword.setForeground(colorViolet);
        textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
        textPassword.setCaretColor(colorViolet);

        textPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textPassword.getText().length() == 0){
                    System.out.println("null");
                    textPassword.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
                }
            }
        });


        labelPasswordConfirm = new JLabel("Confirm Password");
        labelPasswordConfirm.setForeground(colorViolet);
        labelPasswordConfirm.setFont(fontBellMTBold.deriveFont(25f));


        textPasswordConfirm = new JPasswordField();
        textPasswordConfirm.setPreferredSize(new Dimension(600, 40));
        textPasswordConfirm.setFont(fontBellMT.deriveFont(30f));
        textPasswordConfirm.setBackground(colorTextField);
        textPasswordConfirm.setForeground(colorViolet);
        textPasswordConfirm.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
        textPasswordConfirm.setCaretColor(colorViolet);


        textPasswordConfirm.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textPasswordConfirm.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorViolet ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textPasswordConfirm.getText().length() == 0){
                    System.out.println("null");
                    textPasswordConfirm.setBorder(BorderFactory.createMatteBorder(2,7,2,2, colorTextFieldBorder ));
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

        //static
        Controller controller = frame.getController();
        btnSubmit.addActionListener(controller.new BtnSubmitSignUpPanelListener());
        //


        add(btnReturn);
        layout.putConstraint(SpringLayout.NORTH, btnReturn, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, btnReturn, 10, SpringLayout.WEST, this);

        add(labelTitle);
        layout.putConstraint(SpringLayout.WEST, labelTitle, 330, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelTitle, 20, SpringLayout.NORTH, this);

        add(labelName);
        layout.putConstraint(SpringLayout.NORTH, labelName, 90, SpringLayout.NORTH, labelTitle);
        layout.putConstraint(SpringLayout.WEST, labelName, 100, SpringLayout.WEST, this);

        add(textName);
        layout.putConstraint(SpringLayout.NORTH, textName, 30, SpringLayout.NORTH, labelName);
        layout.putConstraint(SpringLayout.WEST, textName, 100, SpringLayout.WEST, this);

        add(labelSurname);
        layout.putConstraint(SpringLayout.NORTH, labelSurname, 70, SpringLayout.NORTH, textName);
        layout.putConstraint(SpringLayout.WEST, labelSurname, 100, SpringLayout.WEST, this);

        add(textSurname);
        layout.putConstraint(SpringLayout.NORTH, textSurname, 30, SpringLayout.NORTH, labelSurname);
        layout.putConstraint(SpringLayout.WEST, textSurname, 100, SpringLayout.WEST, this);


        add(labelLogin);
        layout.putConstraint(SpringLayout.NORTH, labelLogin, 70, SpringLayout.NORTH, textSurname);
        layout.putConstraint(SpringLayout.WEST, labelLogin, 100, SpringLayout.WEST, this);

        add(textLogin);
        layout.putConstraint(SpringLayout.NORTH, textLogin, 30, SpringLayout.NORTH, labelLogin);
        layout.putConstraint(SpringLayout.WEST, textLogin, 100, SpringLayout.WEST, this);


        add(labelPassword);
        layout.putConstraint(SpringLayout.NORTH, labelPassword, 70, SpringLayout.NORTH, textLogin);
        layout.putConstraint(SpringLayout.WEST, labelPassword, 100, SpringLayout.WEST, this);

        add(textPassword);
        layout.putConstraint(SpringLayout.NORTH, textPassword, 30, SpringLayout.NORTH, labelPassword);
        layout.putConstraint(SpringLayout.WEST, textPassword, 100, SpringLayout.WEST, this);

        add(labelPasswordConfirm);
        layout.putConstraint(SpringLayout.NORTH, labelPasswordConfirm, 70, SpringLayout.NORTH, textPassword);
        layout.putConstraint(SpringLayout.WEST, labelPasswordConfirm, 100, SpringLayout.WEST, this);

        add(textPasswordConfirm);
        layout.putConstraint(SpringLayout.NORTH, textPasswordConfirm, 30, SpringLayout.NORTH, labelPasswordConfirm);
        layout.putConstraint(SpringLayout.WEST, textPasswordConfirm, 100, SpringLayout.WEST, this);

        add(btnSubmit);
        layout.putConstraint(SpringLayout.NORTH, btnSubmit, 90, SpringLayout.NORTH, textPasswordConfirm);
        layout.putConstraint(SpringLayout.WEST, btnSubmit, 100, SpringLayout.WEST, this);



    }

    public String[] getUserData(){
        String[] userData = new String[4];

        userData[0] = textName.getText() == null ? "" : textName.getText();
        userData[1] = textSurname.getText() == null ? "" : textSurname.getText();
        userData[2] = textLogin.getText() == null ? "" : textLogin.getText();
        userData[3] = textPassword.getText() == null ? "" : textPassword.getText();

        return userData;
    }

}
