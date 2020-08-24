package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelTitleBar extends JPanel {

    private MainFrame frame;
    private JButton btnExit;
    private JButton btnMinimize;

    public static Point compCoordinate;


    public PanelTitleBar(MainFrame frame){
        this.frame = frame;
        initUI();
    }


    private void initUI(){

        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(13,13,14));

        compCoordinate = null;

        btnExit = new JButton();
        btnExit.setPreferredSize(new Dimension(40,40));
        btnExit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_close_default.png")));
        btnExit.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_close_rollover.png")));
        btnExit.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_close_pressed.png")));
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);

        btnMinimize = new JButton ();
        btnMinimize.setPreferredSize(new Dimension(40,40));
        btnMinimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_minimize_default.png")));
        btnMinimize.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_minimize_selected.png")));
        btnMinimize.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("btn_minimize_pressed.png")));
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setBorder(null);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setOpaque(false);

        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                compCoordinate = e.getPoint();
                //
                System.out.println("x - " + compCoordinate.x);
                System.out.println("y - " + compCoordinate.y);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                compCoordinate = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoordinate = e.getLocationOnScreen();
                frame.setLocation(currCoordinate.x - compCoordinate.x, currCoordinate.y - compCoordinate.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        add(btnMinimize);
        add(btnExit);

    }
}
