package crengine.base.game.basics.contesnt;

import crengine.base.game.WorldContent;

public abstract class BlockBasics extends WorldContent {
    public int size;//首页

    public BlockBasics(String name) {
        super(name);
        this.size = this.drawImage.getWidth();
    }
}
