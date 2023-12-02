package ColorSprites.Common;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
