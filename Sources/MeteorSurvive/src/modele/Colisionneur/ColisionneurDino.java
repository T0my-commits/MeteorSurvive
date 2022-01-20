package modele.Colisionneur;

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
     * @param newX nouvelle coordonnees X ou l'entite veut se deplacer
     * @param newY nouvelle coordonnees Y ou l'entite veut se deplacer
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
