package crengine.base.game.basics.contesnt;

import crengine.base.Keyboards;

public abstract class PlayerBasics extends UnitBasics{

    public PlayerBasics(String name, boolean centre) {
        super(name);
        this.centre = centre;
        this.update = true;
        this.speed = 1f;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void moveX() {
        if (Keyboards.D.use() && !Keyboards.A.use()){
            this.x += this.speed;
        }
        if (Keyboards.A.use() && !Keyboards.D.use()){
            this.x -= this.speed;
        }
    }

    @Override
    public void moveY() {
        if (Keyboards.S.use() && !Keyboards.W.use()){
            this.y += this.speed;
        }
        if (Keyboards.W.use() && !Keyboards.S.use()){
            this.y -= this.speed;
        }
    }
}
