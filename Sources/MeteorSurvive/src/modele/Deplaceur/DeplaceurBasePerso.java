package modele.Deplaceur;

import modele.Boucleur.BoucleurJeu;
import modele.Objet.Entite;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 10;

    /**
     * Défini une nouvelle position pour le dino
     */
    public void setPosition(Entite o, double i, double y) {
        // --------------------- si aucune collision, on dépace le dino
        o.setPosX(i);
        o.setPosY(y);
        // sinon pas de déplacement
    }

    @Override
    public void update() {
        System.out.println("update base");
    }

}
