package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWelcome extends JPanel {

    private JLabel labelImageTop;
    private JButton btnLogin;
    private JButton btnSignUp;
    private SpringLayout layout;
    private JLabel labelBottomSlogan;

    private MainFrame frame;

    public PanelWelcome(MainFrame frame){

        this.frame = frame;
        initUI();
    }


    private void initUI(){
        setBackground(new Color(48,50,55));
        layout = new SpringLayout();
        setLayout(layout);

        labelImageTop = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("label_welcome_image.png")));

        add(labelImageTop);

        layout.putConstraint(SpringLayout.WEST, labelImageTop, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelImageTop, 60, SpringLayout.NORTH, this);

        btnLogin = new JButton();
        btnLogin.setPreferredSize(new Dimension(240, 90));
        /*btnLogin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_default.png")));
        btnLogin.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_rollover.png")));
        btnLogin.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_pressed.png")));*/
        btnLogin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_default.png")));
        btnLogin.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_rollover.png")));
        btnLogin.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_login_pressed.png")));

        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(false);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.changePanel(new PanelLogin(frame));
            }
        });

        btnSignUp = new JButton();
        btnSignUp.setPreferredSize(new Dimension(240, 90));
        btnSignUp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_signup_default.png")));
        btnSignUp.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_signup_rollover.png")));
        btnSignUp.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_signup_pressed.png")));

        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setOpaque(false);

        btnSignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.changePanel(new PanelSignUp(frame));
            }
        });




        //btnLogin.setFont(new Font("Bell MT", Font.PLAIN,40));
        add(btnLogin);
        add(btnSignUp);

        layout.putConstraint(SpringLayout.WEST, btnLogin, 140, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, btnLogin, 400, SpringLayout.NORTH, labelImageTop);

        layout.putConstraint(SpringLayout.WEST, btnSignUp, 270, SpringLayout.WEST, btnLogin);
        layout.putConstraint(SpringLayout.NORTH, btnSignUp, 400, SpringLayout.NORTH, labelImageTop);
        //btnLogin.setForeground(new Color(170, 51, 255));


        labelBottomSlogan = new JLabel();
        labelBottomSlogan.setPreferredSize(new Dimension(500, 50));
        labelBottomSlogan.setForeground(new Color(170, 51, 255));
        labelBottomSlogan.setHorizontalAlignment(JLabel.CENTER);
        labelBottomSlogan.setFont(new Font("Bell MT", Font.PLAIN,26));
        labelBottomSlogan.setText(null);

        add(labelBottomSlogan);

        layout.putConstraint(SpringLayout.WEST, labelBottomSlogan,150, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelBottomSlogan, 100, SpringLayout.SOUTH, btnLogin);

        new Thread(new SloganRunner()).start();


    }

    class SloganRunner implements Runnable{

        private String[] arrayOfSlogans = {"Bitri - Yabba Dabba Duh!", "Step Into The chatting.", "You Need A Bitri.",
                "Call a friend, use it.", "Try Bitri you'll like it.", "Plop, Plop, Fizz, Fizz, Oh, What an app it is!",
                "Run For The friends.", "Bitri just what you needed.", "Hungry? Why Wait? Grab messages.", "You Press " +
                "Sign Up, We Do the Rest."};

        public SloganRunner(){

        }

        @Override
        public void run() {
            while(true){
                for (int i = 0; i < arrayOfSlogans.length; i++){
                    labelBottomSlogan.setText(arrayOfSlogans[i]);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
