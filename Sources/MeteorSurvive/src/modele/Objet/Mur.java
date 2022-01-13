package modele.Objet;

import javafx.scene.shape.Rectangle;

public class Mur extends Entite{
    public Mur(double x, double y) {
        super(x, y, new Rectangle(x,y,100,1000));
    }
}
