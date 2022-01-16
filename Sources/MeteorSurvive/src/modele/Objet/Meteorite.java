package modele.Objet;

import javafx.scene.shape.Rectangle;
import modele.Danger.Danger;

public class Meteorite extends Entite implements Danger {

    private boolean isAffiche = false;
    private boolean isEnable = true;

    public Meteorite(double x, double y){
        super(x,y, new Rectangle(x,y,50, 120));
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

    public void setEtat(boolean b) {
        isEnable = b;
    }

    public boolean isEnable() {
        return isEnable;
    }
}
