package unimi_exercises.old_exams.cambioValuta;

public class Tasso {
    public final Importo impA;
    public final Importo impB;

    public Tasso(Importo importoA, Importo importoB) {
        this.impA = new Importo(importoA.valore(), importoA.valuta);
        this.impB = new Importo(importoB.valore(), importoB.valuta);
    }

    @Override
    public String toString() {
        return this.impA + " = " + this.impB;
    }
}
