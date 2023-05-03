package basic_game.entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import basic_game.main.GamePanel;
import basic_game.main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 25;
        worldY = gp.tileSize * 20;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_up_image-1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_down_image-1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_left_image-1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_right_image-1.png"));

            up2 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_up_image-2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_down_image-2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_left_image-2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("assets/player_assets/player_right_image-2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (!collisionOn) {
                switch(direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            imageCounter++;
            if (imageCounter > 12) {
                if (imageNum == 1) {
                    imageNum = 2;
                } else if (imageNum == 2) {
                    imageNum = 1;
                }
                imageCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.WHITE);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction) {
            case "up":
            if (imageNum == 1) image = up1;
            if (imageNum == 2) image = up2;
            break;
            case "down":
            if (imageNum == 1) image = down1;
            if (imageNum == 2) image = down2;
            break;
            case "left":
            if (imageNum == 1) image = left1;
            if (imageNum == 2) image = left2;
            break;
            case "right":
            if (imageNum == 1) image = right1;
            if (imageNum == 2) image = right2;
            break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
