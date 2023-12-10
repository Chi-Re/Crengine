package crengine.application;

import crengine.ApplicationCore;
import crengine.base.Loadable;

import java.awt.event.WindowEvent;

/**请继承并且返回继承的实例给{@link ApplicationCore}以此启动游戏<br>*具体请看文档*/
public abstract class GameLauncher implements Loadable {
    protected boolean endGame = false;

    /**
     * 初始化，请不要在这里调用{@link crengine.Core}或任何需要初始化的在引擎内的类<br>
     */
    public void init() {}

    /**在窗口初始化完成后才会调用*/
    public void load() {}

    /**在主线程会被重复调用，所以尽量不要写太多无用代码*/
    public void update() {}

    /**你可以更改这里的代码使他运行相应的代码后退出<br>
     * *注意endGame为true时才会正常退出
     * @param e 具体请看{@link WindowEvent}
     */
    public void exit(WindowEvent e) {
        endGame = true;
    }

    public final boolean getEnd(){
        return endGame;
    }
}
