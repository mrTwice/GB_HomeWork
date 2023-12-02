package ColorSprites.Common;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final CanvasRepaintListener controller;
    private long lastFrameTime;
    public MainCanvas(CanvasRepaintListener controller) {
        //setBackground(Color.BLUE);
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.00000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }
    public int getLeft() {return  0;}
    public int getRight() {return  getWidth() - 1;}
    public int getTop() {return  0;}
    public int getBottom() {return getHeight() -1;}

}
