package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Classe d'un pet, hérite de Entite
 */
public class Pet extends Entite {

    /**
     * Information si la météorite est activée ou pas
     * par défaut la météorite est activé
     */
    private boolean isEnable = true;

    /**
     * Constructeur d'un pet
     * @param x Position en X
     * @param y Position en Y
     */
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
