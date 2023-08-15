package gui.currencyConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class OptionList implements ActionListener {
    public JComboBox<String> createOptionList(String[] currencyStrings) {
        return new JComboBox<String>(currencyStrings);
    }

    public JComboBox<String> createCurrencyList() {
        String[] availableCurrencies = {
        "EUR (Euro)", "USD (US dollar)", "JPY (Japanese Yen)", 
        "GBP (Great Britain Pound)", "CHF (Switzerland Franc)", "RUB (Russian Ruble)",
        "CNY (Chinese Yuan/Renminbi)"
        };
        JComboBox<String> myList = createOptionList(availableCurrencies);
        myList.addActionListener(this);
        return createOptionList(availableCurrencies);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        @SuppressWarnings("unchecked")
        JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String currencyName = (String)cb.getSelectedItem();
        getCurrency(currencyName);
    }

    /**
     * Returns the respective currency value in cents of euros.
     * @param currencyName the currency name: USD, EUR, ...
     * @return the value of the selected currency in EUR cents. <br /><br /> Example: getCurrency("USD") => 0.80 (in EUR)
     */
    public int getCurrency(String currencyName) {
        return 0;
    }
    
}
