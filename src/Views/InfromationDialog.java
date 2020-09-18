package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfromationDialog extends JDialog {

    PanelTitleBarDialog panelTitleBar;
    JPanel panelMain;
    JLabel labelContent;
    JButton btnOk;
    SpringLayout layoutPanelMain;

    JTextArea textAreaContent;
    JScrollPane scrollPaneTextAreaContent;


    public InfromationDialog(Frame owner, boolean modal, Color colorOfText, String textOfMessage) {
        super(owner, modal);
        initUI(colorOfText, textOfMessage);
    }


    public InfromationDialog(Frame owner, Color colorOfText, String textOfMessage) {
        super(owner);
        initUI(colorOfText, textOfMessage);
    }

    private void initUI(Color colorOfText, String textOfMessage){
        this.setSize(new Dimension(700, 400));

        panelTitleBar = new PanelTitleBarDialog(this);

        layoutPanelMain = new SpringLayout();
        panelMain = new JPanel(layoutPanelMain);
        panelMain.setBackground(ViewResources.COLOR_BACKGROUND_DIALOG);

        textAreaContent = new JTextArea();
        scrollPaneTextAreaContent = new JScrollPane(textAreaContent);
        scrollPaneTextAreaContent.setPreferredSize(new Dimension(600, 230));
        textAreaContent.setFont(new Font("Bell MT", Font.PLAIN,28));
        textAreaContent.setForeground(colorOfText);
        textAreaContent.setBackground(ViewResources.COLOR_BACKGROUND_DIALOG);
        textAreaContent.setEditable(false);
        textAreaContent.setLineWrap(true);
        textAreaContent.setWrapStyleWord(true);
        scrollPaneTextAreaContent.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTextAreaContent.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ViewResources.COLOR_VIOLET));
        scrollPaneTextAreaContent.setEnabled(true);
        textAreaContent.setText(textOfMessage);

        panelMain.add(scrollPaneTextAreaContent);
        layoutPanelMain.putConstraint(SpringLayout.WEST, scrollPaneTextAreaContent,50, SpringLayout.WEST, panelMain);
        layoutPanelMain.putConstraint(SpringLayout.NORTH, scrollPaneTextAreaContent, 15, SpringLayout.NORTH, panelMain);


        btnOk = new JButton();
        btnOk.setPreferredSize(new Dimension(240, 76));
        btnOk.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_ok_default.png")));
        btnOk.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_ok_rollover.png")));
        btnOk.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_ok_pressed.png")));
        btnOk.setContentAreaFilled(false);
        btnOk.setBorder(null);
        btnOk.setBorderPainted(false);
        btnOk.setOpaque(false);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelMain.add(btnOk);
        layoutPanelMain.putConstraint(SpringLayout.WEST, btnOk, 235, SpringLayout.WEST, panelMain);
        layoutPanelMain.putConstraint(SpringLayout.NORTH, btnOk, 18, SpringLayout.SOUTH, scrollPaneTextAreaContent);


        add(BorderLayout.NORTH, panelTitleBar);
        add(BorderLayout.CENTER, panelMain);

        setUndecorated(true);
        setVisible(true);
    }
}
