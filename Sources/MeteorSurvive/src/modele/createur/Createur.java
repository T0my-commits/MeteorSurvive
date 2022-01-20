package modele.createur;

import modele.Monde;

/**
 * Classe abstraite qui defini quels methodes et attribus un createur doit avoir
 */
public abstract class Createur {
    /**
     * Monde où la classe doit creer
     */
     Monde m;

    /**
     * Constructeur d'un Createur
     * @param m Monde où la classe doit creer
     */
     public Createur(Monde m){
        this.m = m;
     }

    /**
     * Definition du prototype de la fonction de creation
     * @param m Monde où la classe doit creer
     */
    public abstract void creer();

}
