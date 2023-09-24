package unimi_exercises.old_exams.cambioValuta;

public class Tasso {
    public final Importo impA;
    public final Importo impB;

    //RI: impA e impB sono oggetti Importo immutabili, le rispettive valute non possono avere nome o simbolo nulli.
    //AF: Tasso è una classe rappresentata da due proprietà, impA e impB, entrambi di tipo Importo.

    /**
     * Crea un oggetto di tipo Tasso a partire da due importi.
     * @param importoA oggetto di tipo Importo rappresentante un importo.
     * @param importoB oggetto di tipo Importo rappresentante un importo.
     * @throws NullPointerException se nome o simbolo della valuta di un importo sono nulli.
     * @throws IllegalArgumentException se nome o simbolo della valuta di un importo sono vuoti.
     */
    public Tasso(Importo importoA, Importo importoB) {
        this.impA = new Importo(importoA.valore(), importoA.valuta);
        this.impB = new Importo(importoB.valore(), importoB.valuta);
    }

    @Override
    public String toString() {
        return this.impA + " = " + this.impB;
    }
}

