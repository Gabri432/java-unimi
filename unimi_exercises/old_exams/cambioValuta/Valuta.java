package unimi_exercises.old_exams.cambioValuta;

import java.util.Objects;

public class Valuta {
    public final String nome;
    public final String simbolo;

    //RI: nome e simbolo sono non-vuoti, non-nulli e immutabili.
    //AF: Valuta è una classe rappresentata da due proprietà di tipo String, nome e simbolo, immutabili.

    /**
     * Crea un oggetto di tipo Valuta in base al suo nome e al suo simbolo.
     * @param nome stringa che rappresenta il nome della valuta.
     * @param simbolo stringa che rappresenta il simbolo della valuta.
     * @throws NullPointerException se nome o simbolo sono nulli.
     * @throws IllegalArgumentException se nome o simbolo sono vuoti.
     */
    public Valuta(String nome, String simbolo) {
        if (Objects.requireNonNull(nome,  "Nome non può essere nullo.").isEmpty()) {
            throw new IllegalArgumentException("Nome non può essere vuoto.");
        }
        if (Objects.requireNonNull(simbolo,  "Simbolo non può essere nullo.").isEmpty()) {
            throw new IllegalArgumentException("Simbolo non può essere vuoto.");
        }
        this.nome = nome;
        this.simbolo = simbolo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Valuta)) {
            return false;
        }
        Valuta valuta = (Valuta) obj;
        if (valuta.nome != this.nome) return false;
        if (valuta.simbolo != this.simbolo) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, simbolo);
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.simbolo + ")";
    }
}