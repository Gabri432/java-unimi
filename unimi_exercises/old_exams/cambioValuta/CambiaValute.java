package unimi_exercises.old_exams.cambioValuta;

import java.util.ArrayList;

public class CambiaValute {
    private ArrayList<Tasso> tassi;
    private Cassa cassa;

    public void aggiornaTasso() {}

    public float cambiaValutaDiImporto() {
        return 0;
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
