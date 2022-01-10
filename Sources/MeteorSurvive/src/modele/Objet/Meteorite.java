package modele.Objet;

import modele.Danger.Danger;
import modele.hitbox.Hitbox;

public class Meteorite extends Entite implements Danger {



    private boolean isAffiche = false;

    public Meteorite() {
        super(0d,0d, new Hitbox(53,131));
    }
    public Meteorite(double x, double y){
        super(x,y, new Hitbox(53, 131));
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
