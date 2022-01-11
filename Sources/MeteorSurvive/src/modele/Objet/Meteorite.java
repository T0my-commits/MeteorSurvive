package modele.Objet;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Danger.Danger;
import modele.hitbox.Hitbox;

public class Meteorite extends Entite implements Danger {

    private boolean isAffiche = false;

    public Meteorite(double x, double y){
        super(x,y, new Rectangle(x,y,53, 131));
    }

    public Meteorite() {
        this(0d, 0d);
    }

    public boolean isAffiche() {
        return isAffiche;
    }

    public void setAffiche(boolean affiche) {
        isAffiche = affiche;
    }

    @Override
    public void setDegats(Entite o1) {
    }

    @Override
    public String toString() {
        return "Meteorite{ " + getPosX() +" / "+ getPosY()+" }";
    }
}
