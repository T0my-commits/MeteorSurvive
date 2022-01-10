package modele.Objet;

import javafx.scene.shape.Rectangle;
import modele.hitbox.Hitbox;

/**
 * Représente un pet de dinosaure
 */
public class Pet extends Entite {

    public Pet(double x, double y) {
        super(x, y, new Rectangle(x,y,167,155));
    }
}
