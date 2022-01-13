package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.Entite;
import modele.Objet.Entite;
import modele.Objet.Mur;

public class ColisionneurDino extends Colisionneur{

    public static boolean OnGround(Monde m) {
        return OnGround(m, m.getDino());
    }

    public static boolean isColision(Monde m, double newX, double newY){
        if(Colisionneur.isColision(m.getDino(),m,newX,newY)) return true;

        Rectangle newHitbox = new Rectangle(newX, newY, m.getDino().getHitbox().getWidth(), m.getDino().getHitbox().getHeight());
        for (Mur mur: m.getWall()
        ) {
            if(newHitbox.intersects(mur.getHitbox().getBoundsInLocal())) return true;
        }
        return false;
    }

    public static boolean IsbetweenWall(Monde m){
        System.out.println(m.getWall().size());
        for (Mur mur: m.getWall()
             ) {
            if(m.getDino().getHitbox().intersects(mur.getHitbox().getBoundsInLocal())) return false;
        }
        return true;
    }
}
