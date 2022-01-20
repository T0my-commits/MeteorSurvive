package modele.createur;

import modele.Monde;

/**
 * Classe abstraite qui defini quels méthodes et attribus un créateur doit avoir
 */
public abstract class Createur {
    /**
     * Monde où la classe doit créer
     */
     Monde m;

    /**
     * Constructeur d'un Créateur
     * @param m Monde où la classe doit créer
     */
     public Createur(Monde m){
        this.m = m;
     }

    /**
     * Definition du prototype de la fonction de création
     * @param m Monde où la classe doit créer
     */
    public abstract void creer();

}
