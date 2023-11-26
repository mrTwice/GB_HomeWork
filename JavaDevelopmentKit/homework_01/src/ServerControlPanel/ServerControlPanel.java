package ServerControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerControlPanel extends JFrame{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static final String WINDOW_TITLE = "ControlPanel";
    private static final String STATUS_PPREFIX = "Статус сервера: ";
    private static final String BTN_START_TITLE = "Start";
    private static final String BTN_STOP_TITLE = "Stop";
    private JButton btnStart = new JButton(BTN_START_TITLE);
    private JButton btnStop = new JButton(BTN_STOP_TITLE);
    private static final String SERVER_NOT_RUM_MSG = "Server not started";
    private JTextArea textArea = new JTextArea();
    private boolean isServerWorking;

    ServerControlPanel(){
        isServerWorking = false;
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking)
                    isServerWorking = true;
                textArea.append(STATUS_PPREFIX + isServerWorking + "\n");
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isServerWorking) {
                    textArea.append(SERVER_NOT_RUM_MSG  + "\n");
                }
                if (isServerWorking)
                    isServerWorking = false;
                textArea.append(STATUS_PPREFIX + isServerWorking  + "\n");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setAlwaysOnTop(true);
        setResizable(false);
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);
        add(textArea);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);

    }
}
