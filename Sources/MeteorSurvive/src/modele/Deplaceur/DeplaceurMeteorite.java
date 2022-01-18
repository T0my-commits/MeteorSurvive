package modele.Deplaceur;

import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Objet.Entite;
import modele.Sujet;

import java.util.List;

public class DeplaceurMeteorite extends Deplaceur {

    // toutes les NEW_VITESSSE tours de boucle, on augmente la vitesse de chute des météorites;
    private static final int NEW_VITESSE = 100000;

    private static int num_tour_de_boucle;
    private static double xmove = 4d;
    private static double ymove = -0.8d;

    public DeplaceurMeteorite(Sujet s, Monde m) {
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
        num_tour_de_boucle = NEW_VITESSE;
    }

    @Override
    public void update() {
        List<Meteorite> allMereorite = getMonde().getMeteorite();


        for(Meteorite e : allMereorite){
            if(Colisionneur.isColision(e, getMonde(), e.getPosX()+1,e.getPosY())) {
                getMonde().removeEntite(e);
            }
            else{
                if (num_tour_de_boucle == 0) {
                    xmove += 0.0625d;
                    ymove -= 0.0125d;
                    num_tour_de_boucle = NEW_VITESSE;
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

