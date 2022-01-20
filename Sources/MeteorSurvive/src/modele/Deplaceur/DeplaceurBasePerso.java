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
package modele.Deplaceur;

import modele.Bonus.IBonus;
import modele.Colisionneur.ColisionneurDino;
import modele.Colisionneur.ColisionneurItem;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Item.Item;
import modele.Sujet;

import java.util.List;

/**
 * Classe qui gere le deplacement du personnage (le Dino), herite de Deplaceur
 */
public class DeplaceurBasePerso extends Deplaceur {

    /**
     * Gravite applique sur le personnage
     */
    private final double GRAVITE = 9.81;

    /**
     * Velocite du personnage
     */
    private static int velocity = 5;

    /**
     * Nombre de saut disponnible lorsque l'Item correspondant est attrape
     */
    private int nb_double_saut = 5;

    /**
     * Direction où doit se deplacer le personnage
     */
    private int direction;

    int i = 0;

    /**
     * Constructeur d'un DeplaceurBasePerso
     * @param s Boucle qui avertira quand faire le deplacement
     * @param m Monde où le deplacement doit être applique
     */
    public DeplaceurBasePerso(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
    }

    /**
     * Methode pour changer la direction du personnage vers la droite
     */
    public void deplacerDroite(){
        direction = velocity;
    }

    /**
     * Methode pour changer la direction du personnage vers la gauche
     */
    public void deplacerGauche(){
        direction = -velocity;

    }

    /**
     * Methode permettant au personnage de sauter
     */
    public void sauter(){
        if(ColisionneurDino.OnGround(getMonde())){
            getMonde().getDino().setSaute(true);

            if (getMonde().getDino().isDoubleSaut()) {
                if (nb_double_saut >= 0) {
                    nb_double_saut -= 1;
                } else {
                    nb_double_saut = 5;
                    getMonde().getDino().setDoubleSaut(false);
                    getMonde().getDino().setHauteurSaut(40);
                }
            }

            i = getMonde().getDino().getHauteurSaut();
        }
    }

    /**
     * Methode qui deplacera le personnage a chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {

        Dino d = getMonde().getDino();

        if(!ColisionneurDino.IsColision(getMonde(), getMonde().getDino().getPosX()+direction,getMonde().getDino().getPosY())){
            d.updateX(direction);
        }

        if(getMonde().getDino().isSaute()){ // si le personnage est sense sauter
            if(i>(i/2))d.updateY(-((i-(i/2))*(i-(i/2)))*GRAVITE/200);
            else d.updateY(((i-(i/2))*(i-(i/2)))*GRAVITE/200);

            i--;
            if(i==0) getMonde().getDino().setSaute(false);

        }


        if(!ColisionneurDino.OnGround(getMonde()) && i==0){ // si le personnage n'est pas sur le sol
            d.updateY(15);

        }

        Item i = ColisionneurItem.GetItem(getMonde().getDino(), getMonde().getItems());
        if (i != null) {
            if (i.isEnable()) {
                getMonde().addBonus((IBonus) i);
                i.setEtat(false);
                getMonde().removeEntite(i);
            }
        }
    }
}
