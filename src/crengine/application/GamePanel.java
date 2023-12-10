package crengine.application;

import crengine.Core;
import crengine.base.Loadable;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Loadable {
    @Override
    public void init() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (var dialogs : Core.content.getDialog().getAny()){
            dialogs.drawImage(g);
        }
    }
}
