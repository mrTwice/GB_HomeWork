package ChatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

public class ChatClientGUI extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 700;
    private final JTextArea chatField = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2,3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("65535");
    private final JTextField tfLogin = new JTextField("uswr@user.ru");
    private final JPasswordField tfPassword = new JPasswordField("qwerty");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelCenter = new JPanel(new GridLayout(1,2));
    private final JScrollPane scrollChatHistory = new JScrollPane(chatField);
    private final JList<String> userList = new JList<>();

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    
    private static final String HISTORY_FILE_PATH = ".";
    private static final String HISTORY_FILE_NAME = "History.txt";
    
    private boolean isAuth = false;
    


    public ChatClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatClient");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        chatField.setEditable(false);
        panelCenter.add(scrollChatHistory);
        panelCenter.add(userList);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend,BorderLayout.EAST);

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (authorization(tfIPAddress.getText(), tfPort.getText(), tfLogin.getText(), tfPassword.getPassword())) { 
                    isAuth = true;
                    userList.setListData(getContacts());
                    if(checkHistory(HISTORY_FILE_NAME)) {
                        getHistoryChat(HISTORY_FILE_NAME);
                    } else {
                        File histroyFile = new File(HISTORY_FILE_PATH + HISTORY_FILE_NAME );
                    }
                }
            }
        });
        
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAuth) {
                    System.out.println("Yor are not authorized!");
                } else {
                    String message = tfLogin.getText() + ": " + tfMessage.getText() + "\n";
                    chatField.append(message);
                    if(checkHistory(HISTORY_FILE_NAME)) {
                        writeHistoryToFile(message);
                    } else {
                        File historyFile = new File(HISTORY_FILE_PATH + HISTORY_FILE_NAME );
                        writeHistoryToFile(message);
                    }
                    
                }
                tfMessage.setText("");
            }
        });

        /**
         * Отправка сообщения по кнопке ENTER
         */
        tfMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnSend.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setVisible(true);
    }

    /**
     * Метож имитирует получение списка контактов
     * @return
     */
    private String[] getContacts(){
        String[] testArray = {"Дмитрий","Петр","Василий", "Анна", "Владислав", "Юлия"};
        return testArray;
    }

    /**
     * Метод имитирует авторизацию в чате
     * @param ip
     * @param port
     * @param login
     * @param password
     * @return
     */
    private boolean authorization(String ip, String port, String login, char[] password){
        if (!ip.isEmpty() && !port.isEmpty() && !login.isEmpty() && password !=null)
            return true;
        return false;
    }

    /**
     * Метод добавляет запись в файл History при добавлении нового сообщения
     * @param message
     */
    private void writeHistoryToFile(String message){
        try (FileWriter historyWriter = new FileWriter("History.txt", true)) {
            historyWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод восстанавлиает историю часта из файла History
     * @param fileName
     */
    private void getHistoryChat(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String message;
            while ((message = reader.readLine()) != null) {
                chatField.append(message + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод проверяет существует ли архив чата
     * @param fileName
     * @return
     */
    private boolean checkHistory (String fileName){
        if(new File(fileName).exists())
            return true;
        return false;
    }
}
