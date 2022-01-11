package modele.Colisionneur;

import modele.Monde;

public class ColisionneurDino extends Colisionneur{

    public static boolean OnGround(Monde m){
        if(m.getDino().getHitbox().intersects(m.getSol().getHitbox().getBoundsInLocal())) return true;
        return false;
    }
}
