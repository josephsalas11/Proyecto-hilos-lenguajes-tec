package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.Figure;
import main.FiguresPanel;
import main.MoveFigureThread;
import main.PanelRepaint;

public class MainView extends javax.swing.JFrame implements Runnable {

    private JTextField txtSpeed;
    private JTextField txtValue;
    private JTextField txtCarriles;
    
    private JPanel panel;

    private static final int DRAWING_WIDTH = 600;
    private static final int NUMGAMEOBJECTS = 30;
    private int sleepThreadTime;
    private int sleepTimePaint;
    private boolean runningThread;
    private FiguresPanel movingPanel;
    
    private Figure[] gameObjectsArray = new Figure[NUMGAMEOBJECTS];
    private MoveFigureThread[] moveObjectArray = new MoveFigureThread[NUMGAMEOBJECTS];

    /**
     * Creates new form MainView
     */
    public MainView() {
        setTitle("Thread Competition");
        initComponents();
        init();

    }

    private void init() {

        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i] = new Figure(DRAWING_WIDTH);
            moveObjectArray[i] = new MoveFigureThread(gameObjectsArray[i],
                    sleepThreadTime,
                    "Thread " + i,
                    this.runningThread);
        }//end for

        movingPanel = new FiguresPanel(gameObjectsArray, DRAWING_WIDTH);
        this.panel.add(movingPanel);

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanel menuPanel = new JPanel();


        panel = new JPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)));
        menuPanel.setLayout(null);

        txtSpeed = new JTextField();
        txtSpeed.setText("Speed");
        txtSpeed.setBounds(293, 11, 86, 20);
        menuPanel.add(txtSpeed);
        txtSpeed.setColumns(10);

        txtValue = new JTextField();
        txtValue.setText("Value");
        txtValue.setBounds(197, 11, 86, 20);
        menuPanel.add(txtValue);
        txtValue.setColumns(10);

        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnCreate.setBounds(197, 41, 182, 23);
        menuPanel.add(btnCreate);

        txtCarriles = new JTextField();
        txtCarriles.setText("Carriles");
        txtCarriles.setBounds(464, 42, 67, 20);
        menuPanel.add(txtCarriles);
        txtCarriles.setColumns(10);

        JButton btnBarrier = new JButton("Barrier");
        btnBarrier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBarrier.setBounds(464, 10, 89, 23);
        menuPanel.add(btnBarrier);

        JButton btnRevert = new JButton("Revert");
        btnRevert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRevert.setBounds(628, 10, 89, 23);
        menuPanel.add(btnRevert);

        JButton btnSimulation = new JButton("Simulation");
        btnSimulation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSimulation.setBounds(628, 41, 89, 23);
        menuPanel.add(btnSimulation);

        JButton btnInterrupt = new JButton("Interrupt");
        btnInterrupt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInterrupt.setBounds(819, 10, 89, 54);
        menuPanel.add(btnInterrupt);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    @Override
    public void run() {

    }

}
