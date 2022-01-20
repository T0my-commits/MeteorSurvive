package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * Classe d'un mur, hérite de Entite
 */
public class Mur extends Entite{

    /**
     * Constructeur d'un mur
     * @param x Position en X
     * @param y Position en Y
     */
    public Mur(double x, double y) {

        super(x, y, new Rectangle(x,y,1,1000));

    }
}
