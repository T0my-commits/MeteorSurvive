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
 * Classe qui gere le déplacement du personnage (le Dino), hérite de Déplaceur
 */
public class DeplaceurBasePerso extends Deplaceur {

    /**
     * Gravité appliqué sur le personnage
     */
    private final double GRAVITE = 9.81;

    /**
     * Vélocité du personnage
     */
    private static int velocity = 5;

    /**
     * Nombre de saut disponnible lorsque l'Item correspondant est attrapé
     */
    private int nb_double_saut = 5;

    /**
     * Direction où doit se déplacer le personnage
     */
    private int direction;

    int i = 0;

    /**
     * Constructeur d'un DéplaceurBasePerso
     * @param s Boucle qui avertira quand faire le déplacement
     * @param m Monde où le déplacement doit être applique
     */
    public DeplaceurBasePerso(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        gravite = 9.81;
    }

    /**
     * Méthode pour changer la direction du personnage vers la droite
     */
    public void deplacerDroite(){
        direction = velocity;
    }

    /**
     * Méthode pour changer la direction du personnage vers la gauche
     */
    public void deplacerGauche(){
        direction = -velocity;

    }

    /**
     * Méthode permettant au personnage de sauter
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
     * Méthode qui déplacera le personnage à chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {

        Dino d = getMonde().getDino();

        if(!ColisionneurDino.IsColision(getMonde(), getMonde().getDino().getPosX()+direction,getMonde().getDino().getPosY())){
            d.updateX(direction);
        }

        if(getMonde().getDino().isSaute()){ // si le personnage est sensé sauter
            if(i>(i/2))d.updateY(-((i-(i/2))*(i-(i/2)))*gravite/200);
            else d.updateY(((i-(i/2))*(i-(i/2)))*gravite/200);

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
