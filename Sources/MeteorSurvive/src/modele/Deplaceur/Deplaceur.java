package modele.Deplaceur;

import modele.Monde;
import modele.Observateur;
import modele.Sujet;

/**
 * Classe abstraite qui defini quels methodes et attribus un deplaceur doit avoir
 */
public abstract class Deplaceur implements Observateur {

    /**
     * Boucleur qui notifiera a chaque tour de boucle
     */
    private Sujet boucleur; // instancie dans les classes filles

    /*
    Mon où le deplacement sera effectue
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
