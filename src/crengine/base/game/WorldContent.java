package crengine.base.game;

import crengine.Core;
import crengine.base.DisplayContent;
import crengine.base.game.entity.Entity;
import crengine.base.game.entity.EntityGroup;

/**组成世界的模块*/
public abstract class WorldContent extends DisplayContent implements Entity {
    //暂时无用(为了方便调用对比)
    public final int id;
    /**是否会更新*/
    public boolean update;
    /**是否为中心，也就是说，是否为玩家控制(或者玩家本身)*/
    public boolean centre = false;

    public WorldContent(String name) {
        super(name);
        id = EntityGroup.nextId();
        x=0;
        y=0;
        update = false;
    }

    @Override
    public void update() {
    }
}
