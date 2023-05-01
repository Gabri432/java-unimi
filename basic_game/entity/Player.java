package basic_game.entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import basic_game.main.GamePanel;
import basic_game.main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_up_image-1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_down_image-1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_left_image-1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_right_image-1.png"));

            up2 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_up_image-2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_down_image-2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_left_image-2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("player_assets/player_right_image-2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        }
        if (keyH.downPressed) {
            direction = "down";
            y += speed;
        }
        if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.WHITE);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction) {
            case "up":
            image = up1;
            break;
            case "down":
            image = down1;
            break;
            case "left":
            image = left1;
            break;
            case "right":
            image = right1;
            break;
            default:
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
