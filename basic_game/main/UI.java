package basic_game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import basic_game.objects.OBJ_chest;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage chestImage;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_chest chest = new OBJ_chest();
        chestImage = chest.image;
    }

    public void draw(Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(chestImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x = "+ gp.player.hasChest, 74, 60);
    }
}
