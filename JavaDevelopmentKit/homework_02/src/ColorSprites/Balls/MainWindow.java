package ColorSprites.Balls;

import ColorSprites.Common.CanvasRepaintListener;
import ColorSprites.Common.Interactable;
import ColorSprites.Common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener{

    private static final int POS_X = 200;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Interactable[] interactables = new Interactable[10];
    private final Background background = new Background();

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        interactables[0] = new Background();
        for (int i =1; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i =0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }

    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i =0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }

    }

    public static void main(String[] args) {
        new MainWindow();
    }
}