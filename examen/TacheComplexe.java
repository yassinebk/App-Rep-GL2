package examen;

import java.util.*;

public class TacheComplexe implements Tache, Iterable<Tache> {
    private Collection<Tache> sousTaches;
    private String nom;

    public TacheComplexe(String nom) {
        this.nom = nom;
        this.sousTaches = new ArrayList<Tache>();
    }

    
    public void triNom(Comparator<Tache> Namecomp) {
        Collections.sort((List<Tache>) sousTaches, Namecomp);
        for (Tache e : this.sousTaches) {
            System.out.println(e.getNom() + e.getCout());
        }
    }
    
    public void tricout(Comparator<Tache> Coutcomp) {
        Collections.sort((List<Tache>) sousTaches, Coutcomp);
        for (Tache e : this.sousTaches) {
            System.out.println(e.getNom() + e.getCout());
        }
    }
    
    public void afficher() {
        System.out.println(
            "la Tache  " + this.nom + " du cout " + getCout() + " contient ces taches ");
            for (Tache e : this.sousTaches) {
                System.out.println(e.getNom());
            }
        }
        
        public Iterator<Tache> iterator() {
            return this.sousTaches.iterator();
        }
        
        public void ajouter(Tache tache) {
            this.sousTaches.add(tache);
        }
    
        public void supprimer(Tache tache) {
            this.sousTaches.remove(tache);
        }
    
        public String getNom() {
            return this.nom;
        }
    
        public int getCout() {
            int c = 0;
            for (Tache e : this.sousTaches) {
                c += e.getCout();
            }
            ;
            return c;
        }
    }
    