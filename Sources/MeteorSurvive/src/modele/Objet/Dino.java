package modele.Objet;

import modele.hitbox.Hitbox;

public class Dino extends Entite {

    private int pdv = 3;
    public Dino(double x, double y) {
        super(x,y, new Hitbox(110,110));
    }
}
