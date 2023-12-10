package crengine.base.game;

import crengine.base.DisplayContent;

import crengine.base.game.basics.contesnt.BlockBasics;
import crengine.base.game.basics.contesnt.UnitBasics;
import crengine.util.serialization.ObjectList;
import crengine.util.serialization.ObjectMap;

import java.util.concurrent.CopyOnWriteArrayList;

/**关于游戏内容*/
public class ContentLoader {
    /**所有的，可能对于模组开发有用*/
    private final ObjectMap<String, DisplayContent> content = new ObjectMap<>();

    private final ObjectMap<String, BlockBasics> blocks = new ObjectMap<>();
    private final ObjectMap<String, UnitBasics> units = new ObjectMap<>();

    private final CopyOnWriteArrayList<WorldContent> worldContents = new CopyOnWriteArrayList<>();
    /**窗口会绘制的*/
    private final ObjectList<UserInterfaceContent> drawDialog = new ObjectList<>();

    public ContentLoader(){
    }

    public void addContent(DisplayContent content){
        //是的，名字也是很重要的
        this.content.add(content.name, content);
    }

    public ObjectMap<String, DisplayContent> getContent() {
        return this.content;
    }

    public void addUnit(UnitBasics unit){
        this.units.add(unit.name, unit);
    }

    public void addBlock(BlockBasics block){
        this.blocks.add(block.name, block);
    }

    public ObjectMap<String, BlockBasics> getBlocks() {
        return blocks;
    }

    public ObjectMap<String, UnitBasics> getUnits() {
        return units;
    }


    public CopyOnWriteArrayList<WorldContent> getWorldContents() {
        return this.worldContents;
    }
    public void addWorld(WorldContent worldContent){
        this.worldContents.add(worldContent);
    }


    public void removeDialog(UserInterfaceContent me){
        this.drawDialog.remove(me);
    }

    public void addDialog(UserInterfaceContent me){
        this.drawDialog.add(me);
    }

    public ObjectList<UserInterfaceContent> getDialog(){
        return this.drawDialog;
    }

    public void toFirstDialog(UserInterfaceContent me){
        this.removeDialog(me);
        this.addDialog(me);
    }

    public boolean contains(UserInterfaceContent me){
        return this.drawDialog.contains(me);
    }
}
