package unimi_exercises.old_exams.cambioValuta;

import java.util.Objects;

public class Importo {
    private float valore;
    private final Valuta valuta;
    
    public Importo(float valore, Valuta valuta) {
        this.valore = valore;
        this.valuta = valuta;
    }
    
    public float sommaAlgebrica(float quantità) {
        return 0;
    }

    public float somma() {
        return 0;
    }

    public float sottrai() {
        return 0;
    }

    @Override
    public String toString() {
        return this.valuta.simbolo + " " + this.valore;
    }

    
}
