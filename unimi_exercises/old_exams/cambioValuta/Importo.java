package unimi_exercises.old_exams.cambioValuta;

import java.math.BigDecimal;
import java.util.Objects;

public class Importo {
    private BigDecimal valore;
    public final Valuta valuta;

    //RI: L'importo non può avere una valuta di nome o simbolo vuoti o nulli.
    //AF: Importo è una classe concreta rappresentata da due proprietà, la stringa "valore", e l'oggetto "valuta" di tipo Valuta.
    
    /**
     * Costruisce un oggetto di tipo importo a partire da un valore di partenza e dalla sua valuta.
     * @param valore float rappresentante il valore dell'importo. 
     * @param valuta oggetto di tipo Valuta rappresentante la valuta dell'importo.
     * @throws NullPointerException se nome o simbolo sono nulli.
     * @throws IllegalArgumentException se nome o simbolo sono vuoti.
     */
    public Importo(float valore, Valuta valuta) {
        this.valore = BigDecimal.valueOf(valore);
        this.valuta = new Valuta(valuta.nome, valuta.simbolo);
    }
    
    /**
     * Somma algebricamente la quantità e il valore corrente dell'importo.
     * @param quantità float rappresentante la quantità che verrà aggiunta o tolta dal valore dell'importo.
     */
    public void sommaAlgebrica(float quantità) {
        this.valore.add(BigDecimal.valueOf(quantità));
    }

    /**
     * Incrementa il valore dell'importo.
     * @param valore float rappresentante l'incremento del valore.
     * @throws IllegalArgumentException se il valore è non-positivo.
     */
    public void somma(float valore) {
        if (valore > 0) {
            this.valore.add(BigDecimal.valueOf(valore));
        } else {
            throw new IllegalArgumentException("Il valore da sommare deve essere positivo");
        }
    }

    /**
     * Riduce il valore dell'importo.
     * @param valore float rappresentante il decremento dell'importo.
     * @throws IllegalArgumentException se il valore è non-positivo.
     */
    public void sottrai(float valore) {
        if (valore > 0) {
            this.valore.min(BigDecimal.valueOf(valore));
        } else {
            throw new IllegalArgumentException("Il valore da sottrarre deve essere positivo");
        }
    }

    /**
     * Restituisce il valore dell'importo.
     * @return il valore dell'importo.
     */
    public float valore() {
        return this.valore.floatValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Importo)) {
            return false;
        }
        Importo importo = (Importo) obj;
        if (importo.valore != this.valore) return false;
        if (importo.valuta != this.valuta) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore, valuta);
    }

    @Override
    public String toString() {
        return this.valuta.simbolo + " " + this.valore;
    }

    
}

