package modele.Objet;

import modele.Danger.Danger;
import modele.Objet.Objet;

import java.util.Random;

public class Meteorite extends Objet implements Danger {



    private boolean isAffiche = false;

    public Meteorite() {
        super(0d,0d,1);
    }
    public Meteorite(double x, double y){
        super(x,y,1);
    }

    public boolean isAffiche() {
        return isAffiche;
    }

    public void setAffiche(boolean affiche) {
        isAffiche = affiche;
    }

    @Override
    public void setDegats(Objet o1) {

    }


    @Override
    public String toString() {
        return "Meteorite{ " + getPosX() +" / "+ getPosY()+" }";
    }
}
