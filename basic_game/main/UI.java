package basic_game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import basic_game.objects.OBJ_chest;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage chestImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_chest chest = new OBJ_chest();
        chestImage = chest.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if (gameFinished) {
            int x, y;
            String text;
            int textLength;
            text = "You have completed the game in " + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.tileSize/2 - textLength/2;
            y = gp.tileSize/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);
        }
        g2.drawImage(chestImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x = "+ gp.player.hasChest, 74, 60);

        playTime += (double) 1/60;
        g2.drawString("Time: "+dFormat.format(playTime), gp.tileSize*11, 65);

        if (messageOn) {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

            messageCounter++;

            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }
    }
}
