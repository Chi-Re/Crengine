package crengine.base.game.entity;

public interface Entity {
    default void update(){
        this.update(null);
    }

    default void update(Runnable run){
        if (run != null) run.run();
    }
}
