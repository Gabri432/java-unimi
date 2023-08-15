package gui.currencyConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
        getCurrency(currencyName.split(" ")[0]);
    }

    /**
     * Returns the corresponding currency value in thousandths of euros. The lowest value returned will be 1.
     * @param currencyName the currency name: USD, EUR, ...
     * @return the value of the selected currency in EUR cents. <br /><br /> Example: getCurrency("USD") => 920 (which is 0.92 in EUR)
     */
    public int getCurrency(String currencyName) {
        HashMap<String, Integer> currencyMap = new HashMap<String, Integer>(); 
        currencyMap.putIfAbsent("EUR",1000);
        currencyMap.putIfAbsent("USD",920);
        currencyMap.putIfAbsent("JPY",6);
        currencyMap.putIfAbsent("GBP",116);
        currencyMap.putIfAbsent("CHF",104);
        currencyMap.putIfAbsent("RUB",9);
        currencyMap.putIfAbsent("CNY",13);
        return currencyMap.get(currencyName);
    }
    
}
