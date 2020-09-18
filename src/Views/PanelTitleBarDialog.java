package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTitleBarDialog extends JPanel {

    private InfromationDialog dialog;
    private JButton btnExit;

    public static Point compCoordinate;


    public PanelTitleBarDialog(InfromationDialog dialog){
        this.dialog = dialog;
        initUI();
        //dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    private void initUI(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(ViewResources.COLOR_TITLE_BAR_BACKGROUND);

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

        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
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
                dialog.setLocation(currCoordinate.x - compCoordinate.x, currCoordinate.y - compCoordinate.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });


        add(btnExit);

    }

}
