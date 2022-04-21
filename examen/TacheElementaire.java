package examen;

public class TacheElementaire implements Tache {
    int cout;
    String nom;
    TacheElementaire(){}

    TacheElementaire(int cout, String nom) {
        this.cout = cout;
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public int getCout() {
        return this.cout;
    }

}
