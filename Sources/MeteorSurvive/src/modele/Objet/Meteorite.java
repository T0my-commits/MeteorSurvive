package modele.Objet;

import modele.Danger.Danger;
import modele.Objet.Objet;

public class Meteorite  extends Objet implements Danger {

    public Meteorite() {
        setPosX(0);
        setPosY(0);
    }
    public Meteorite(int x, int y){
        setPosX(x);
        setPosY(y);
    }

    @Override
    public void setDegats(Objet o1) {

    }

    @Override
    public String toString() {
        return "Meteorite{ " + getPosX() +" / "+ getPosY()+" }";
    }
}
