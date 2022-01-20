package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


/**
 * Classe d'un sol, herite de Entite
 */
public class Sol extends Entite {
    /**
     * Constructeur d'un sol
     */
    public Sol() {
        super(0, 590, new Rectangle(0, 619, 1280, 101));
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png")));

    }
}
