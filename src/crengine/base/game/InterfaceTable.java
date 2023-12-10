package crengine.base.game;

import crengine.base.DisplayContent;
import crengine.base.game.entity.Entity;

/**显示UI模块(显示与交互)*/
public abstract class InterfaceTable extends DisplayContent implements Entity {
    public InterfaceTable(String name) {
        super(name);
    }

    @Override
    public void update(Runnable run) {
    }
}
