package examen;

import java.util.Comparator;

public class CompNom implements Comparator<Tache> {

    public CompNom() {
    }

    public int compare(Tache o1, Tache o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
