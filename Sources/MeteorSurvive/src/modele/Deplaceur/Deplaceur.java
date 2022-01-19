package modele.Deplaceur;

import modele.Monde;
import modele.Observateur;
import modele.Sujet;

public abstract class Deplaceur implements Observateur {

    private Sujet boucleur; // instancié dans les classes filles
    private Monde monde;

    public Sujet getBoucleur() {
        return boucleur;
    }

    public void setBoucleur(Sujet boucleur) {
        this.boucleur = boucleur;
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }
}
