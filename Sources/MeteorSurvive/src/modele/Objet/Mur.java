package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Mur extends Entite{
    public Mur(double x, double y) {

        super(x, y, new Rectangle(x,y,1,1000));
    }
}
