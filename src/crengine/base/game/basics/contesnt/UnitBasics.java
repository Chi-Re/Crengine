package crengine.base.game.basics.contesnt;

import crengine.Core;
import crengine.base.game.entity.EntityMove;
import crengine.base.game.WorldContent;

public abstract class UnitBasics extends WorldContent implements EntityMove {
    /**碰撞箱*/
    public float hitboxHigh, hitboxWide;

    public float speed;

    public boolean centre;

    public UnitBasics(String name) {
        super(name);
        this.hitboxWide = this.drawImage.getWidth();
        this.hitboxHigh = this.drawImage.getHeight();
        //基础速度
        this.speed = 0f;
        this.centre = false;

        Core.content.addUnit(this);
    }

    @Override
    public void update() {
        //TODO 我很担心这会不会出现问题
        this.action();
        //this.drawImage.set(this.x, this.y);
    }

    @Override
    public void init() {
    }

    private void hasten() {

    }
}
