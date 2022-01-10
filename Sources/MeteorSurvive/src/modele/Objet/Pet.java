package modele.Objet;

import modele.hitbox.Hitbox;

/**
 * Représente un pet de dinosaure
 */
public class Pet extends Entite {

    public Pet(double x, double y) {
        super(x, y, new Hitbox(167,155));
    }
}
