package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.Mur;

/**
 * Colisionneur qui gere uniquement les colision du Dino, etends Colisionneur car il se sert des methodes de colisions basique
 */
public class ColisionneurDino extends Colisionneur{

    /**
     * Methode qui indique si le dinosaur est sur le sol ou non
     * @param m Monde où on veut savoir si le Dino est sur le sol
     * @return true si il est sur le sol, false sinon
     */
    public static boolean OnGround(Monde m) {
        return OnGround(m, m.getDino());
    }


    /**
     * Methode qui gere la colision entre le dino et le monde
     * @param m Monde où on veut savoir si le Dino est en Colision
     * @param newX nouvelle coordonnées X ou l'entité veut se déplacer
     * @param newY nouvelle coordonnées Y ou l'entité veut se déplacer
     * @return true si il y a une colision, false sinon
     */
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
