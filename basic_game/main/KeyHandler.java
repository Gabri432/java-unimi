package basic_game.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_W:
            upPressed = true;
            break;
            case KeyEvent.VK_A:
            leftPressed = true;
            break;
            case KeyEvent.VK_S:
            rightPressed = true;
            break;
            case KeyEvent.VK_D:
            downPressed = true;
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_W:
            upPressed = false;
            break;
            case KeyEvent.VK_A:
            leftPressed = false;
            break;
            case KeyEvent.VK_S:
            rightPressed = false;
            break;
            case KeyEvent.VK_D:
            downPressed = false;
            break;
        }
    }
}
