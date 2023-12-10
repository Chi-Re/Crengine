package crengine.base.game.entity;

public interface EntityMove {
    void moveX();

    void moveY();

    default void action(){
        this.moveX();
        this.moveY();
    }
}
