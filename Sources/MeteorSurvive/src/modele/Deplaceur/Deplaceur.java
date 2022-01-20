package modele.Deplaceur;

import modele.Monde;
import modele.Observateur;
import modele.Sujet;

/**
 * Classe abstraite qui defini quels méthodes et attribus un déplaceur doit avoir
 */
public abstract class Deplaceur implements Observateur {

    /**
     * Boucleur qui notifiera a chaque tour de boucle
     */
    private Sujet boucleur; // instancié dans les classes filles

    /*
    Mon où le déplacement sera effectué
     */
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
