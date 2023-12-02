package Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ControlPanel extends JFrame implements IServerListener {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static final String WINDOW_TITLE = "ControlPanel";
    private static final String BTN_START_TITLE = "Start";
    private static final String BTN_STOP_TITLE = "Stop";
    private JButton btnStart = new JButton(BTN_START_TITLE);
    private JButton btnStop = new JButton(BTN_STOP_TITLE);
    private JTextArea textArea = new JTextArea();
    private final Date now = new Date();
    private final Server server;

    public ControlPanel(){
        server = new Server(this);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
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

    @Override
    public void receiveMessage(String message) {
        textArea.append(now.toString() + ":   " + message + "\n");
    }

    public static void main(String[] args) {
        new ControlPanel();
    }
}
