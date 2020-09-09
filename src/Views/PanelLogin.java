package Views;

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
    private JLabel labelUsername;
    private JTextField textUsername;
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


        labelUsername = new JLabel("Username");
        labelUsername.setForeground(ViewResources.COLOR_VIOLET);
        labelUsername.setFont(ViewResources.getFontBellMtBold().deriveFont(25f));


        textUsername = new JTextField();
        textUsername.setPreferredSize(new Dimension(600, 40));
        textUsername.setFont(ViewResources.getFontBellMt().deriveFont(25f));
        textUsername.setBackground(ViewResources.COLOR_TEXT_FIELD);
        textUsername.setForeground(ViewResources.COLOR_VIOLET);
        textUsername.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
        textUsername.setCaretColor(ViewResources.COLOR_VIOLET );

        textUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textUsername.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_VIOLET ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
                if (textUsername.getText().length() == 0){
                    System.out.println("null");
                    textUsername.setBorder(BorderFactory.createMatteBorder(2,7,2,2, ViewResources.COLOR_TEXT_FIELD_BORDER ));
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
                System.out.println("focusLost");
                if (textPassword.getText().length() == 0){
                    System.out.println("null");
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


        add(btnReturn);
        layout.putConstraint(SpringLayout.NORTH, btnReturn, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, btnReturn, 10, SpringLayout.WEST, this);

        add(labelTitle);
        layout.putConstraint(SpringLayout.NORTH, labelTitle, 20, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST, labelTitle, 330, SpringLayout.WEST,this);

        add(labelUsername);
        layout.putConstraint(SpringLayout.NORTH, labelUsername, 120, SpringLayout.NORTH, labelTitle);
        layout.putConstraint(SpringLayout.WEST, labelUsername, 100, SpringLayout.WEST, this);

        add(textUsername);
        layout.putConstraint(SpringLayout.NORTH, textUsername, 40, SpringLayout.NORTH, labelUsername);
        layout.putConstraint(SpringLayout.WEST, textUsername, 100, SpringLayout.WEST, this);

        add(labelPassword);
        layout.putConstraint(SpringLayout.NORTH, labelPassword, 80, SpringLayout.NORTH, textUsername);
        layout.putConstraint(SpringLayout.WEST, labelPassword, 100, SpringLayout.WEST, this);

        add(textPassword);
        layout.putConstraint(SpringLayout.NORTH, textPassword, 40, SpringLayout.NORTH, labelPassword);
        layout.putConstraint(SpringLayout.WEST, textPassword, 100, SpringLayout.WEST, this);

        add(btnSubmit);
        layout.putConstraint(SpringLayout.NORTH, btnSubmit, 100, SpringLayout.NORTH, textPassword);
        layout.putConstraint(SpringLayout.WEST, btnSubmit, 100, SpringLayout.WEST, this);
    }


}
