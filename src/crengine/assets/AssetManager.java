package crengine.assets;

import crengine.assets.graphics.Texture;
import crengine.base.FileType;
import crengine.util.io.CRFile;
import crengine.util.serialization.ObjectMap;

import java.util.Objects;

/**操作与储存的工具类*/
public class AssetManager {
    public final int TEXTURE_SIZE = 32;

    protected final CRFile DIRECTORY;
    /**扫描png文件(本来是自定义来着，不过问题太多了)*/
    protected final ObjectMap<String, Texture> assetImage = new ObjectMap<>();

    protected final ObjectMap<String, CRFile> assetData = new ObjectMap<>();

    public final Texture empty = new Texture(new CRFile("icon.png", FileType.internal));

    public AssetManager(CRFile assets){
        this.DIRECTORY = assets;
        for (var img : DIRECTORY.getExtFiles(".")){
            if (Objects.equals(img.getDataType(), "png")) {
                this.addImage(img.getName(), new Texture(img));
            } else {
                this.addData(img.getName(), img);
            }
        }
    }

    public void addImage(Texture texture){
        this.addImage(texture.getFile().getName(), texture);
    }

    public void addImage(String name, Texture texture){
        this.assetImage.add(name, texture);
    }

    public ObjectMap<String, Texture> getImage(){
        return this.assetImage;
    }


    public void addData(String name, CRFile file){
        this.assetData.add(name, file);
    }

    public void addData(CRFile file){
        this.addData(file.getName(), file);
    }

    public ObjectMap<String, CRFile> getData() {
        return this.assetData;
    }

    public CRFile getDIRECTORY() {
        return this.DIRECTORY;
    }
}
