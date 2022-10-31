package gui;

import javax.swing.JButton;

public class Button {
    public Button() {
        JButton b = new JButton("click"); //creating instance of JButton  
        b.setBounds(130,100,100, 40); //x axis, y axis, width, height 
    }

    public Button(short x, short y, short width, short height, String text) {
        JButton b = new JButton(text); //creating instance of JButton  
        b.setBounds(x,y,width, height); //x axis, y axis, width, height 
    }

    public static void main(String[] args) {
        new Button();
    }
}
