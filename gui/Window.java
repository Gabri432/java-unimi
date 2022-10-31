package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {
    public Window() {
        JFrame f = new JFrame(); //creating instance of JFrame  
          
        JButton b = new JButton("click"); //creating instance of JButton  
        b.setBounds(130,100,100, 40); //x axis, y axis, width, height  
                  
        f.add(b);//adding button in JFrame  
                  
        f.setSize(400,500); //400 width and 500 height  
        // setLocation(200, 200); //Deciding where the window is going to appear on the screen
        f.setLocationRelativeTo(null); //Window will appear at the center of the screen
        f.setLayout(null); //using no layout managers  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closing the window will close the program
        f.setVisible(true); //making the frame visible 
    }

    public static void main(String[] args) {
        new Window();
    }
}