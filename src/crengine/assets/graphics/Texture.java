package crengine.assets.graphics;

import crengine.base.FileType;
import crengine.util.exception.CrengineRuntimeException;
import crengine.util.io.CRFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**图片类，好吧，这个名字确实不太好，不过用作UI或贴图也不错*/
public class Texture {
    private final CRFile textureFile;
//可显示内容
    public int width, height;

    public Texture(CRFile file){
        try {
            this.textureFile = file;
            BufferedImage bufferedImage = ImageIO.read(file.getLocalStream());
            this.width = bufferedImage.getWidth();
            this.height = bufferedImage.getHeight();
        } catch (IOException e){
            throw new CrengineRuntimeException(e);//可绘制
        }
    }

    public Texture(String path){
        this(path, FileType.local);
    }

    public Texture(String path, FileType type){
        this(new CRFile(path, type));
    }

    public CRFile getFile(){
        return this.textureFile;
    }

    public BufferedImage getImage(){
        try {
            return ImageIO.read(this.textureFile.getLocalStream());
        } catch (IOException e) {
            throw new CrengineRuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return this.textureFile.toString();
    }
}
