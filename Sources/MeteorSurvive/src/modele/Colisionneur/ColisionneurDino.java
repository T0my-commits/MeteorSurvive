package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.Mur;

public class ColisionneurDino extends Colisionneur{

    public static boolean OnGround(Monde m) {
        return OnGround(m, m.getDino());
    }

    public static boolean IsColision(Monde m, double newX, double newY){
        if(Colisionneur.IsColision(m.getDino(),m,newX,newY)){
            System.out.println("COLISION Dino");
            return true;
        }

        Rectangle newHitbox = new Rectangle(newX, newY, m.getDino().getHitbox().getWidth(), m.getDino().getHitbox().getHeight());
        for (Mur mur: m.getWall()
        ) {
            if(newHitbox.intersects(mur.getHitbox().getBoundsInLocal())) {
                return true;
            }
        }
        return false;
    }
}
