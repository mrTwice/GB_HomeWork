package TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static final String FIELD_SIZE_PREFIX = "Размер игрового поля: ";
    private static final String FIELD_LENGTH_PREFIX = "Длина победной комбинации: ";
    private static final String BTN_START_LABEL = "Start new game";
    private static final String GAME_MODE_LABEL = "Режим игры";
    private static final int FIELD_SIZE_SLIDER_LENGTH_MIN = 3;
    private static final int FIELD_SIZE_SLIDER_LENGTH_MAX = 10;
    private static final int FIELD_SIZE_SLIDER_DEFAULT_VALUE = FIELD_SIZE_SLIDER_LENGTH_MIN;
    private static final int WIN_COMBINATION_SLIDER_LENGTH_MIN = 3;
    private static final int WIN_COMBINATION_SLIDER_LENGTH_MAX = 10;
    private static final int WIN_COMBINATION_SLIDER_LENGTH_DEFAULT_VALUE = WIN_COMBINATION_SLIDER_LENGTH_MIN;
    private static final String HUMAN_VS_AI_JRBTN_LABEL = "Человек против компьютера";
    private static final String HUMAN_VS_HUMAN_JRBTN_LABEL = "Человек против человека";
    private static final int MODE_HUMAN_VS_AI =0;
    private static final int MODE_HUMAN_VS_HUMAN =1;

    private JButton btnStart = new JButton(BTN_START_LABEL);
    private JLabel gameMode = new JLabel(GAME_MODE_LABEL);
    private JLabel gameField = new JLabel(FIELD_SIZE_PREFIX);
    private JLabel winCount = new JLabel(FIELD_LENGTH_PREFIX);
    private JSlider fieldSizeSlider = new JSlider(FIELD_SIZE_SLIDER_LENGTH_MIN, FIELD_SIZE_SLIDER_LENGTH_MAX, FIELD_SIZE_SLIDER_DEFAULT_VALUE);
    private JSlider lengthWinCombinationSlider = new JSlider(WIN_COMBINATION_SLIDER_LENGTH_MIN, WIN_COMBINATION_SLIDER_LENGTH_MAX, WIN_COMBINATION_SLIDER_LENGTH_DEFAULT_VALUE);
    private JRadioButton humanVsAi = new JRadioButton(HUMAN_VS_AI_JRBTN_LABEL);
    private JRadioButton humanVsHuman = new JRadioButton(HUMAN_VS_HUMAN_JRBTN_LABEL);
    private ButtonGroup gameModeGroup = new ButtonGroup();
    private JPanel panBottom;

    SettingsWindow(GameWindow gameWindow) {
        setLocation((int) (gameWindow.getLocation().getX()+gameWindow.getSize().width/2 - WINDOW_WIDTH/2),
                    (int) (gameWindow.getLocation().getY()+gameWindow.getSize().height/2 - WINDOW_HEIGHT/2));
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(8, 1));
        gameModeGroup.add(humanVsAi);
        gameModeGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAi);
        panBottom.add(humanVsHuman);
        panBottom.add(gameField);
        panBottom.add(fieldSizeSlider);
        panBottom.add(winCount);
        panBottom.add(lengthWinCombinationSlider);
        panBottom.add(btnStart);
        humanVsAi.setSelected(true);
        gameField.setText(FIELD_SIZE_PREFIX + FIELD_SIZE_SLIDER_DEFAULT_VALUE);
        winCount.setText(FIELD_LENGTH_PREFIX + WIN_COMBINATION_SLIDER_LENGTH_DEFAULT_VALUE);

        fieldSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = fieldSizeSlider.getValue();
                gameField.setText(FIELD_SIZE_PREFIX + currentValue);
                lengthWinCombinationSlider.setMaximum(currentValue);
            }
        });

        lengthWinCombinationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winCount.setText(FIELD_LENGTH_PREFIX + lengthWinCombinationSlider.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(
                        humanVsAi.isSelected()?MODE_HUMAN_VS_AI:MODE_HUMAN_VS_HUMAN,
                        fieldSizeSlider.getValue(),
                        fieldSizeSlider.getValue(),
                        lengthWinCombinationSlider.getValue()
                );
                setVisible(false);
            }
        });
        add(panBottom);
    }
}
