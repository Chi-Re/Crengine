package crengine.application;

import crengine.assets.graphics.Texture;
import crengine.base.FileType;
import crengine.util.io.CRFile;
import crengine.util.serialization.ObjectMap;

/**
 * 方便填写设置而制作的类。<br>
 * <pre>
 *     new AppConfig(){{
 *         title = "appName";
 *         width = 114;
 *         height = 514;
 *     }}
 * </pre>
 * 类似以上的方法设置，顺便作为变量储存在ApplicationCore中。
 * @author 炽热S
 */
public class AppConfig {
    public String title = "title";

    public int width = 100, height = 100;

    public Texture icon = new Texture("icon.png");

    private CRFile assetDirectory = new CRFile("assets/", FileType.internal);

    private GamePanel panel;

    private final ObjectMap<String, String> test = new ObjectMap<>();

    public AppConfig(){
    }

    public CRFile getAssetDirectory() {
        return this.assetDirectory;
    }

    public void setAssetDirectory(String path) {
        this.assetDirectory = new CRFile(path, FileType.internal);
    }

    public void setAssetDirectory(CRFile assetDirectory) {
        this.assetDirectory = assetDirectory;
    }


    public GamePanel getPanel() {
        return this.panel;
    }
    public void setPanel(GamePanel panel){
        this.panel = panel;
    }

    public ObjectMap<String, String> getTest() {
        return test;
    }
    public void setTest(String a, String b){
        this.test.add(a, b);
    }
}
