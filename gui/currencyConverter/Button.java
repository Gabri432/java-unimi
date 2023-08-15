package gui.currencyConverter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Button {
    public static JButton generateButton(String textButton, String toolTipText, int keyboardButton) {
        JButton button = new JButton(textButton);
        button.setMnemonic(keyboardButton);
        button.setToolTipText(toolTipText);
        return button;
    }

    public static JCheckBox generateCheckButton(String textButton, String toolTipText, boolean selected) {
        JCheckBox button = new JCheckBox(textButton);
        button.setToolTipText(toolTipText);
        button.setSelected(selected);
        button.setActionCommand(textButton);
        return button;
    }

    public static JRadioButton generateRadioButton(String textButton, String toolTipText, boolean selected) {
        JRadioButton button = new JRadioButton(textButton);
        button.setToolTipText(toolTipText);
        button.setSelected(selected);
        button.setActionCommand(textButton);
        return button;
    }

}
