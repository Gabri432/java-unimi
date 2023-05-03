package basic_game.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY, speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int imageCounter = 0;
    public int imageNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
