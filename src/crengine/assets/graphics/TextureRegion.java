package crengine.assets.graphics;

import crengine.Core;
import crengine.base.Drawable;

import java.awt.*;

/**游戏内绘制的类*/
public class TextureRegion implements Drawable {
    private final Texture texture;

    private int width, height;

    private int x, y;

    public TextureRegion(Texture texture, int x, int y, int width, int height) {
        if (texture == null) texture = Core.asset.empty;
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public TextureRegion(Texture texture, int x, int y){
        this(texture, x, y, texture.width, texture.height);
    }

    public TextureRegion(Texture texture) {
        this(texture, 0, 0, texture.width, texture.height);
    }

    public TextureRegion(String path){
        this(new Texture(path));
    }

    public void set(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    @Override
    public void drawImage(Graphics g, int x, int y) {
        this.set(x, y);
        g.drawImage(this.getImage(), this.x, this.y, this.width, this.height, null);
    }

    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(), this.x, this.y, this.width, this.height, null);
    }

    protected Image getImage() {
        return this.texture.getImage();
    }

    @Override
    public String toString(){
        return texture.toString();
    }
}
