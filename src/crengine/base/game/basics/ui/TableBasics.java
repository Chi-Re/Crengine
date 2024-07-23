package crengine.base.game.basics.ui;

import crengine.base.DisplayContent;
import crengine.base.game.entity.Entity;

/**显示UI模块(显示与交互)*/
public abstract class TableBasics extends DisplayContent implements Entity {

    public TableBasics(String name) {
        super(name);
        x = 0;
        y = 0;
    }

    @Override
    public void update() {

    }
}
