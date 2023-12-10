package crengine.base;

import java.awt.*;

/**可绘制对象*/
public interface Drawable {
    void drawImage(Graphics g, int x, int y);

    default void drawImage(Graphics g){
        this.drawImage(g, 0, 0);
    };
}
