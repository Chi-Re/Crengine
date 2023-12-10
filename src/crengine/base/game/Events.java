package crengine.base.game;

import crengine.base.EventType;
import crengine.util.serialization.ObjectList;
import crengine.util.serialization.ObjectMap;

/**简单的事件监控*/
public class Events {
    private static final ObjectMap<Object, ObjectList<Runnable>> events = new ObjectMap<>();

    /**
     * 简单的事件写入<br>
     * 可以类似于{@link crengine.base.EventType}这样创建事件，不过需要{@code fire()}调用事件。
     */
    public static void on(Class<?> type, Runnable run){
        if (events.get(type) == null){
            ObjectList<Runnable> lr = new ObjectList<>();
            lr.add(run);
            events.add(type, lr);
        } else {
            ObjectList<Runnable> lr = events.get(type);
            lr.add(run);
            events.put(type, lr);
        }
    }

    public static <T> void on(T type, Runnable run){
        on(type.getClass(), run);
    }

    /**
     * 存在的事件会返回Runnable运行<br>
     * 但退出时有可能不会运行
     */
    public static void fire(Class<?> type){
        if (events.get(type) != null){
            for (var lr : events.get(type).getAny()){
                lr.run();
            }
        }
    }

    public static <T> void fire(T type){
        fire(type.getClass());
    }
}
