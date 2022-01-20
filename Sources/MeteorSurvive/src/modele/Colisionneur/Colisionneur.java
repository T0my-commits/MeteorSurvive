package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.*;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Objet.Item.Item;
import modele.Objet.Pet;

/**
 * Classe qui gere les colisions entres les entitées du jeu
 */
public class Colisionneur {
public abstract class Colisionneur {

    /**
     * Methode qui sert a verifier pour une entité qui veut se déplacer si elle entre en colision avec une autre entité
     * @param e entité dont on veut savoir si il y a une colision
     * @param m Monde où on verifie si il y a colision
     * @param newX nouvelle coordonnées X ou l'entité veut se déplacer
     * @param newY nouvelle coordonnées Y ou l'entité veut se déplacer
     * @return true si il y a colision, false sinon
     */
    public static boolean isColision(Entite e, Monde m, double newX, double newY){
        if(m.getAllEntite().size()==0) return false; // si il n'y a pas d'entité il n'y a pas de colisions (si il y a un mauvais appel de la focntion)
        Rectangle newCoord = new Rectangle(newX, newY, e.getHitbox().getWidth(), e.getHitbox().getHeight()); // on creer la nouvelle hitbox
    public static boolean IsColision(Entite e, Monde m, double newX, double newY){
        if(m.getAllEntite().size()==0) return false;
        Rectangle newCoord = new Rectangle(newX, newY, e.getHitbox().getWidth(), e.getHitbox().getHeight());
        for (Entite entite: m.getAllEntite()
             ) {
            // pas de collision entre un pet et un dino;
            if (e instanceof Pet && entite instanceof Dino) continue;
            if (e instanceof Dino && entite instanceof Pet) continue;

            // pas de collision entre une météorite et un item;
            if (e instanceof Meteorite && entite instanceof Item) continue;
            if (e instanceof Item && entite instanceof Meteorite) continue;

            // pas de collision entre un dino et le sol dans cette fonction;
            if (e instanceof Dino && entite instanceof Sol) return false;

            if (newCoord.intersects((entite.getHitbox().getBoundsInLocal())) && !entite.equals(e)){ // si colision
                if(entite instanceof Mur); // si c'est un mur on ne s'occupe pas de la colision
                else if((e instanceof Meteorite && entite instanceof Dino) || (e instanceof Dino && entite instanceof Meteorite)){ // si colision entre Dino et meteorite
                    if(e instanceof Dino) {
                        if(((Meteorite) entite).isEnable()){
                            m.infligerDegat((Meteorite) entite);
                            return true;
                        }
                    }
                    else {
                        if(((Meteorite) e).isEnable()){
                            m.infligerDegat((Meteorite) e);
                            return true;
                        }
                    }
                }
                else return true;
            }

        }
        return false;
    }

    /**
     * Methode qui sert a savoir si une entité est sur le sol
     * @param m Monde où on veut verifier la colisions
     * @param e entité dont on veut savoir si il y a colision avec le sol
     * @return true si il est sur le sol, false sinon
     */
    public static boolean OnGround(Monde m, Entite e) {
        return m.getSol().getHitbox().intersects(e.getHitbox().getBoundsInLocal());
    }
}
