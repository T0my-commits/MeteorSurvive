package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.*;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Objet.Pet;

public class Colisionneur {

    public static boolean isColision(Entite e, Monde m, double newX, double newY){
        if(m.getAllEntite().size()==0) return false;
        Rectangle newCoord = new Rectangle(newX, newY, e.getHitbox().getWidth(), e.getHitbox().getHeight());
        for (Entite entite: m.getAllEntite()
             ) {
            if (e instanceof Pet && entite instanceof Dino) return false;
            if (e instanceof Dino && entite instanceof Pet) return false;
            if (e instanceof Dino && entite instanceof Sol) return false;
            if (newCoord.intersects((entite.getHitbox().getBoundsInLocal())) && !entite.equals(e)){
                if(entite instanceof Mur);
                else return true;
            }

        }
        return false;
    }

    public static boolean OnGround(Monde m, Entite e) {
        return m.getSol().getHitbox().intersects(e.getHitbox().getBoundsInLocal());
    }
}
