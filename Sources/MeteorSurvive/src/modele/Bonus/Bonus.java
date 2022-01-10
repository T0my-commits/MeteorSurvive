package modele.Bonus;

import modele.Objet.Entite;

/**
 * Interface qui défini un objet de type bonus
 */
public interface Bonus {

    /**
     * Méthode qui donne des points de vie à un objet
     * @param o1 L'objet qui reçoie les points de vie
     * @param nbPoints Le nombre de points à ajouter
     */
    public void addPointDeVie(Entite o1, int nbPoints);
}
