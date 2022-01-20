package modele.Deplaceur;

import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Sujet;
import modele.Variables;

import java.util.List;

/**
 * Classe qui gere le deplacement des Meteorites, herite de Deplaceur
 */
public class DeplaceurMeteorite extends Deplaceur {

    /**
     * Nombre de tour de boucle avant d'augmenter la vitesse
     */
    private static int num_tour_de_boucle;

    /**
     * deplacement en X a chaque tout de boucle
     */
    private static double xmove;

    /**
     * deplacement en Y a chaque tout de boucle
     */
    private static double ymove;


    /**
     * Constructeur d'un DeplaceurMeteorite
     * @param s Boucle qui avertira quand faire le deplacement
     * @param m Monde où le deplacement doit être applique
     */
    public DeplaceurMeteorite(Sujet s, Monde m) {
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
        num_tour_de_boucle = Variables.NEW_VITESSE;
        xmove = Variables.XMOVE_BASE;
        ymove = Variables.YMOVE_BASE;
    }

    /**
     * Methode qui deplacera les Meteorites a chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {
        List<Meteorite> allMereorite = getMonde().getMeteorite();

        for(Meteorite e : allMereorite){
            if(Colisionneur.IsColision(e, getMonde(), e.getPosX()+1,e.getPosY())) {
                getMonde().removeEntite(e);
            }
            else{
                if (num_tour_de_boucle == 0) {
                    xmove += 0.0625d;
                    ymove -= 0.0125d;
                    num_tour_de_boucle = Variables.NEW_VITESSE;
                }
                else {
                    num_tour_de_boucle -= 1;
                }

                e.updateY(xmove);
                e.updateX(ymove);
            }
        }
    }


}

