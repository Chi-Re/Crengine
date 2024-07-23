package crengine;

import crengine.application.AppConfig;
import crengine.application.GameLauncher;
import crengine.application.GamePanel;
import crengine.assets.AssetManager;
import crengine.base.EventType;
import crengine.base.Keyboards;
import crengine.base.game.ContentLoader;
import crengine.base.game.Events;
import crengine.base.game.basics.contesnt.PlayerBasics;
import crengine.base.game.basics.ui.dialog.GameDialog;
import crengine.util.CRLog;
import crengine.util.io.CRFile;
import crengine.util.thread.Time;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * 客户端驱动器，可以通过自定义GameLauncher来创建自己的游戏。<br>
 * ApplicationCore不建议修改，因为我没有对此进行兼容，在使用时可以直接new ApplicationCore();
 * @author 炽热S
 */
public class ApplicationCore extends JFrame {
    protected final AppConfig config;

    public ApplicationCore(GameLauncher gl, AppConfig config){
        this.config = config;
        //初始化基础
        this.init();
        //自定义初始化与更新
        gl.init();

        //加载窗口
        this.setTitle(this.config.title);
        this.setIconImage(this.config.icon.getImage());

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //为了方便用户自定义退出程序
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(this.config.width, this.config.height);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keyboards.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Keyboards.remove(e.getKeyCode());
            }
        });

        Events.on(EventType.ClientExitEvent.class, ()->{
            Time.timeStop = true;
            //有一定概率出现问题...
            ApplicationCore.this.dispose();
            System.exit(0);
        });


        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //其实我也不确定
                gl.exit(e);
                Events.fire(EventType.ClientExitEvent.class);
            }
        });


        if (this.config.getPanel() == null){
            this.config.setPanel(new GamePanel());
        }

        //这里加载的图形绘制
        this.config.getPanel().init();
        this.config.getPanel().load();

        //这里会加载所有添加ClientStartupEvent事件的代码
        Events.fire(EventType.ClientStartupEvent.class);
        gl.load();
        //TODO 注意的，我不确定这副作用，恐怕需要改进
        this.add(this.config.getPanel());
        this.setVisible(true);

        //如果为空，就返回基础开始界面(一般测试用)
        if (Core.content.getDialog().getAny().size() == 0) {
            Core.content.addDialog(new GameDialog());
        }

        Time.runTask(5, ()->{
            this.config.getPanel().repaint();
            Core.settings.setSize(this.getSize().width, this.getSize().height);
            gl.update();
        });
    }

    protected final void init(){
        Core.settings = new Settings();
        //默认设置，可以在游戏制作时更改
        Core.settings.setDataDirectory(new CRFile("./"));
        Core.settings.setAppName(this.config.title);
        Core.settings.setSize(this.getSize().width, this.getSize().height);

        if (CRLog.logFile.exists()) CRLog.logFile.deleteFile();

        Core.asset = new AssetManager(this.config.getAssetDirectory());

        Core.content = new ContentLoader();
        //初始化所有显示内容
        for (var c : Core.content.getContent().getValue()){
            c.init();
        }
    }
}
