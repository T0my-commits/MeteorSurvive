package modele.Objet;

import modele.Danger.Danger;
import modele.Objet.Objet;

public class Meteorite extends Objet implements Danger {

    public Meteorite() {
        super(0d,0d,1);
    }
    public Meteorite(double x, double y){
        super(x,y,1);
    }

    @Override
    public void setDegats(Objet o1) {

    }


    @Override
    public String toString() {
        return "Meteorite{ " + getPosX() +" / "+ getPosY()+" }";
    }
}
