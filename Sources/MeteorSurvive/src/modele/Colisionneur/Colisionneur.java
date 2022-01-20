/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/

package modele.Colisionneur;

import javafx.scene.shape.Rectangle;
import modele.Monde;
import modele.Objet.*;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Objet.Item.Item;
import modele.Objet.Pet;

/**
 * Classe qui gere les colisions entres les entitees du jeu
 */

public abstract class Colisionneur {

    /**
     * Methode qui sert a verifier pour une entite qui veut se deplacer si elle entre en colision avec une autre entite
     * @param e entite dont on veut savoir si il y a une colision
     * @param m Monde où on verifie si il y a colision
     * @param newX nouvelle coordonnees X ou l'entite veut se deplacer
     * @param newY nouvelle coordonnees Y ou l'entite veut se deplacer
     * @return true si il y a colision, false sinon
     */
    public static boolean IsColision(Entite e, Monde m, double newX, double newY){
        if(m.getAllEntite().size()==0) return false; // si il n'y a pas d'entite il n'y a pas de colisions (si il y a un mauvais appel de la focntion)
        Rectangle newCoord = new Rectangle(newX, newY, e.getHitbox().getWidth(), e.getHitbox().getHeight()); // on creer la nouvelle hitbox
        for (Entite entite: m.getAllEntite()
             ) {
            // pas de collision entre un pet et un dino;
            if (e instanceof Pet && entite instanceof Dino) continue;
            if (e instanceof Dino && entite instanceof Pet) continue;

            // pas de collision entre une meteorite et un item;
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
     * Methode qui sert a savoir si une entite est sur le sol
     * @param m Monde où on veut verifier la colisions
     * @param e entite dont on veut savoir si il y a colision avec le sol
     * @return true si il est sur le sol, false sinon
     */
    public static boolean OnGround(Monde m, Entite e) {
        return m.getSol().getHitbox().intersects(e.getHitbox().getBoundsInLocal());
    }
}

