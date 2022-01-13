package modele.Bonus;

import modele.Objet.Dino;
import modele.Objet.Entite;

/**
 * Interface qui défini un objet de type bonus
 */
public interface IBonus {

    /**
     * Méthode qui modifie un attribut d'un objet
     * @param o1 L'objet qui reçoie les modifications
     * @param value la nouvelle valeur de l'attribut modifié
     */
    public void addBonus(Dino o1, int value);
}
