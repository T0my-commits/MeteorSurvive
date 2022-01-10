package modele.Objet;

import javafx.scene.shape.Rectangle;
import modele.hitbox.Hitbox;

public class Dino extends Entite {

    private int pdv = 3;
    public Dino(double x, double y) {
        super(x,y, new Rectangle(x,y,110,110));
    }
}
