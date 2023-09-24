package unimi_exercises.old_exams.cambioValuta;

import java.util.HashMap;

public class Cassa {
    //private final ArrayList<Importo> importi;
    private final HashMap<Valuta, Float> importi;

    //RI: Gli importi non possono essere null.
    //AF: Cassa è una classe rappresentata da un ArrayList di oggetti di tipo Importo.

    /**
     * Crea un oggetto di tipo cassa.
     */
    public Cassa() {
        HashMap<Valuta, Float> importiIniziali = new HashMap<Valuta, Float>();
        float baseValue = 0;
        importiIniziali.putIfAbsent(new Valuta("Euro", "€"), baseValue);
        importiIniziali.putIfAbsent(new Valuta("Dollaro", "$"), baseValue);
        importiIniziali.putIfAbsent(new Valuta("Yen", "¥"), baseValue);
        importiIniziali.putIfAbsent(new Valuta("Lira", "Lira"), baseValue);
        importiIniziali.putIfAbsent(new Valuta("Sterlina", "£"), baseValue);
        this.importi = importiIniziali;
    }

    /**
     * Versa un dato importo in cassa.
     * @param importo rappresentante l'importo da versare alla cassa.
     * @throws IllegalArgumentException se l'importo ha valore non-positivo.
     */
    public void versa(Importo importo) {
        if (this.importi.containsKey(importo.valuta)) {
            importo.somma(this.importi.get(importo.valuta));
            this.importi.put(importo.valuta, importo.valore());

        }
    }

    /**
     * Versa un certo valore di una specifica valuta in cassa.
     * @param valore rappresentante il valore da versare alla cassa.
     * @param valuta rappresentante la valuta del valore da versare alla cassa.
     * @throws IllegalArgumentException se il valore è non-positivo o la valuta ha nome o simbolo nulli o vuoti.
     */
    public void versa(float valore, Valuta valuta) {
        this.versa(new Importo(valore, valuta));
    }


    /**
     * Preleva un dato importo dalla cassa.
     * @param importo rappresentante l'importo da prelevare dalla cassa.
     * @throws IllegalArgumentException se l'importo ha valore non-positivo.
     */
    public void preleva(Importo importo) {
        if (this.importi.containsKey(importo.valuta)) {
            importo.sottrai(this.importi.get(importo.valuta));
            this.importi.put(importo.valuta, importo.valore());
        }
    }

    /**
     * Preleva un certo valore di una specifica valuta dalla cassa.
     * @param valore rappresentante il valore da prelevare dalla cassa.
     * @param valuta rappresentante la valuta del valore da prelevare dalla cassa.
     * @throws IllegalArgumentException se il valore è non-positivo o la valuta ha nome o simbolo nulli o vuoti.
     */
    public void preleva(float valore, Valuta valuta) {
        this.preleva(new Importo(valore, valuta));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Cassa:\n");
        for (var valuta: importi.keySet()) {
            Importo importo = new Importo(importi.get(valuta), valuta);
            if (importo.valore() > 0) {
                s.append(importo + "\n");
            }
        }
        return super.toString();
    }
}
