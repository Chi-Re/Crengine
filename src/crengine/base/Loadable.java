package crengine.base;

public interface Loadable {
    default void init(){}

    default void load(){}

    default String getName(){
        return getClass().getSimpleName();
    }
}
