package gui.console;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextArea extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public TextArea() {
        super(new GridBagLayout());

        textField = new JTextField(20);
        textField.addActionListener(this);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Making the scrollpane as wide and tall as the window
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        //Making the textfield as wide as the window 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append("java>gui>console> '" + text + "'"+ newline);
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new TextArea());

        //Display the window at the center
        frame.setLocationRelativeTo(null);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
