package crengine.base.game.basics.ui.dialog;

import crengine.Core;
import crengine.base.game.WorldContent;
import crengine.base.game.basics.contesnt.PlayerBasics;
import crengine.base.game.basics.ui.DialogBasics;
import crengine.util.serialization.ObjectList;

import java.awt.*;

public class GameDialog extends DialogBasics {
    private final ObjectList<WorldContent> worldDraw = new ObjectList<>();

    private PlayerBasics player;

    public GameDialog(PlayerBasics player) {
        super("root", 0);
        this.player = player;

    }

    public GameDialog(){
        this(new PlayerBasics("null", true) {});
    }

    @Override
    public void update() {
        if (location == this.full || this.width != Core.settings.getAppWidth() ||
                this.height != Core.settings.getAppHeight()){
            this.setSize(Core.settings.getAppWidth(), Core.settings.getAppHeight());
        }


    }

    @Override
    public void drawImage(Graphics g) {
        this.player.drawImage(g);
        this.player.update();

        for (var b : this.worldDraw.getAny()){
            b.drawImage(g);
            b.update();
        }
    }

    public ObjectList<WorldContent> getWorldDraw(){
        return this.worldDraw;
    }

    public void addWorld(WorldContent worldContent){
        this.worldDraw.add(worldContent);
    }
}
