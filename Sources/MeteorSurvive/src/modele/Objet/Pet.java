package modele.Objet;

import javafx.scene.shape.Rectangle;

/**
 * Représente un pet de dinosaure
 */
public class Pet extends Entite {

    private boolean isEnable = true;

    public Pet(double x, double y) {
        super(x, y, new Rectangle(x,y,40,36));
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEtat(boolean enable) {
        isEnable = enable;
    }
}
