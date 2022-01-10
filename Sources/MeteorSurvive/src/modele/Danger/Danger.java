package modele.Danger;

import modele.Objet.Entite;

/**
 * Interface qui défini un objet dangereux
 */
public interface Danger {

    /**
     * Méthode qui applique des dégats
     * @param o1 L'objet qui reçoie les dégâts
     */
    public void setDegats(Entite o1);
}
