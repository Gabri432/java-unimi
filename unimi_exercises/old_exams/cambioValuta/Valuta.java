package unimi_exercises.old_exams.cambioValuta;

import java.util.Objects;

public class Valuta {
    public final String nome;
    public final String simbolo;

    /**
     * 
     * @param nome
     * @param simbolo
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
    public String toString() {
        return this.nome + " (" + this.simbolo + ")";
    }
}