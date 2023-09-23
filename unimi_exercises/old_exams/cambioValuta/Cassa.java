package unimi_exercises.old_exams.cambioValuta;

import java.util.ArrayList;

public class Cassa {
    private ArrayList<Importo> importi;

    public Cassa() {
        this.importi = new ArrayList<Importo>();
        importi.add(new Importo(0, new Valuta("null", "null")));
    }

    public void versa() {}

    public float preleva() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (var importo: importi) {
            if (importo.valore() > 0) {
                s.append(importo);
            }
        }
        return super.toString();
    }
}
