package unimi_exercises.old_exams.cambioValuta;

import java.util.ArrayList;

public class Cassa {
    private ArrayList<Importo> importi;

    //RI: Gli importi non possono essere null.
    //AF: Cassa è una classe rappresentata da un ArrayList di oggetti di tipo Importo.

    /**
     * Crea un oggetto di tipo cassa.
     */
    public Cassa() {
        this.importi = new ArrayList<Importo>();
        importi.add(new Importo(0, new Valuta("null", "null")));
    }

    /**
     * Versa un dato importo in cassa.
     * @param importo rappresentante l'importo da versare alla cassa.
     * @throws IllegalArgumentException se l'importo ha valore non-positivo.
     */
    public void versa(Importo importo) {}

    /**
     * Versa un certo valore di una specifica valuta in cassa.
     * @param valore rappresentante il valore da versare alla cassa.
     * @param valuta rappresentante la valuta del valore da versare alla cassa.
     * @throws IllegalArgumentException se il valore è non-positivo o la valuta ha nome o simbolo nulli o vuoti.
     */
    public void versa(float valore, Valuta valuta) {}


    /**
     * Preleva un dato importo dalla cassa.
     * @param importo rappresentante l'importo da prelevare dalla cassa.
     * @throws IllegalArgumentException se l'importo ha valore non-positivo.
     */
    public Importo preleva(Importo importo) {
        return new Importo(0, new Valuta("null", "null"));
    }

    /**
     * Preleva un certo valore di una specifica valuta dalla cassa.
     * @param valore rappresentante il valore da prelevare dalla cassa.
     * @param valuta rappresentante la valuta del valore da prelevare dalla cassa.
     * @throws IllegalArgumentException se il valore è non-positivo o la valuta ha nome o simbolo nulli o vuoti.
     */
    public float preleva(float valore, Valuta valuta) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Cassa:\n");
        for (var importo: importi) {
            if (importo.valore() > 0) {
                s.append(importo + "\n");
            }
        }
        return super.toString();
    }
}

// 1:34:08 rimasti
