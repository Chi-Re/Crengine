package crengine.base.game.basics.ui;

import crengine.Core;
import crengine.base.DisplayContent;
import crengine.base.Location;
import crengine.base.game.basics.ui.subassembly.Button;
import crengine.base.game.entity.Entity;
import crengine.util.serialization.ObjectList;

import java.awt.*;

/**
 * 显示UI内容(面板)
 * @author 炽热S
 */
public abstract class DialogBasics extends DisplayContent implements Entity {
    /**
     * 屏幕显示方式<br>
     * <code>
     *     full-填满屏幕
     *     center-显示在中心
     *     <br>
     *     top-顶部显示
     *     bottom-底部显示
     *     left-左边显示
     *     right-右边显示
     * </code>
     */
    public final int
            full=0, center=1,
            top=2, bottom=3, left=4, right=5;


    public int location;

    public boolean update = false;

    private final ObjectList<TableBasics> cont = new ObjectList<>();

    public int width, height;

    public DialogBasics(String name, int location) {
        super(name);
        this.x=0;
        this.y=0;
        this.location = location;
    }

    public DialogBasics(String name){
        this(name, 0);
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }


    @Override
    public void update(Runnable run) {
        if (location == this.full || this.width != Core.settings.getAppWidth() ||
                this.height != Core.settings.getAppHeight()){
            this.setSize(Core.settings.getAppWidth(), Core.settings.getAppHeight());
        }

        for (var b : this.cont.getAny()){
            b.update();
        }
    }

    @Override
    public void drawImage(Graphics g) {
        this.drawImage(g, this.x, this.y);
    }

    public void show(){
        Core.content.addDialog(this);
    }

    public void hide(){
        Core.content.removeDialog(this);
    }

    public boolean isShown(){
        return Core.content.getDialog().contains(this);
    }

    public void toggle(){
        if(isShown()){
            hide();
        }else{
            show();
        }
    }


    public void button(String name, Runnable run){
        this.cont.add(new Button(name, run));
    }
}
