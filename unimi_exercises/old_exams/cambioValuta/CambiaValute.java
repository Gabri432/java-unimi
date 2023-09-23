package unimi_exercises.old_exams.cambioValuta;

import java.util.ArrayList;

public class CambiaValute {
    private ArrayList<Tasso> tassi;
    private Cassa cassa;

    //RI:
    //AF: CambiaValute è una classe concreta rappresentata da due proprietà, "tassi", ArrayList di oggetti Tasso, e "cassa", di tipo Cassa. 

    /**
     * Aggiorna un tasso di cambio.
     * @param tasso il nuovo tasso di cambio.
     * @throws NullPointerException se il tasso è nullo.
     */
    public void aggiornaTasso(Tasso tasso) {}


    /**
     * Cambia il valore di un importo nel suo equivalente in un'altra valuta.
     * @param importo rappresentante l'importo che si vuole cambiare.
     * @param valutadiDestinazione rappresentante la valuta finale in cui si vuole avere il valore.
     * @return il corrispondente importo nella valuta desiderata.
     * @throws IllegalArgumentException se l'importo ha valore non-positivo.
     */
    public Importo cambiaValutaDiImporto(Importo importo, Valuta valutadiDestinazione) {
        return new Importo(0, new Valuta("", ""));
    }

    /**
     * Cambia il valore associato ad una valuta nel suo equivalente in un'altra valuta.
     * @param valore float rappresentante il valore che si desidera cambiare. 
     * @param valutaDiPartenza rappresentante la valuta iniziale del valore da cambiare.
     * @param valutadiDestinazione rappresentante la valuta finale in cui si vuole avere il valore.
     * @return il corrispondente importo nella valuta desiderata.
     * @throws IllegalArgumentException se il valore è non-positivo.
     */
    public Importo cambiaValutaDiImporto(float valore, Valuta valutaDiPartenza, Valuta valutadiDestinazione) {
        return new Importo(0, new Valuta("", ""));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Tassi:\n");
        for (var tasso: tassi) {
            s.append(tasso + "\n");
        }
        return super.toString();
    }
}
