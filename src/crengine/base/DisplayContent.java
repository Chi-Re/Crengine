package crengine.base;

import crengine.Core;
import crengine.assets.graphics.Texture;
import crengine.assets.graphics.TextureRegion;

import java.awt.*;

public abstract class DisplayContent implements Loadable, Drawable {
    public final String name;

    public int x, y;

    public final TextureRegion drawImage;

    public DisplayContent(String name){
        this.name = name;
        this.drawImage = this.TextureImage();
        this.init();
        Core.content.addContent(this);
        this.load();
    }

    public TextureRegion TextureImage(){
        Texture t = Core.asset.getImage().get(this.name);
        if (t == null) t = Core.asset.empty;
        return new TextureRegion(t);
    }

    @Override
    public void drawImage(Graphics g, int x, int y) {
        this.drawImage.drawImage(g, x, y);
    }

    @Override
    public void drawImage(Graphics g) {
        this.drawImage(g, this.x, this.y);
    }

    @Override
    public String toString(){
        return name;
    }
}
