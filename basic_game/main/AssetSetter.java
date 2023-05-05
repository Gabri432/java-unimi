package basic_game.main;

import basic_game.objects.OBJ_chest;

public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_chest();
        gp.obj[0].worldX = 21*gp.tileSize;
        gp.obj[0].worldY = 10*gp.tileSize;
    }

}
