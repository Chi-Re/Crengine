package crengine.base;

public interface Location {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    default void setXY(int x, int y){
        this.setX(x);
        this.setY(y);
    }
}
