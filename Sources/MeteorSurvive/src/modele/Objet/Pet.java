package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Représente un pet de dinosaure
 */
public class Pet extends Entite {

    private boolean isEnable = true;

    public Pet(double x, double y) {
        super(x, y, new Rectangle(x,y,40,36));
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/pet_001.png")));

    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEtat(boolean enable) {
        isEnable = enable;
    }
}
