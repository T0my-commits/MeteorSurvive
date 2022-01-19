package modele.Deplaceur;

import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Sujet;
import modele.Variables;

import java.util.List;

public class DeplaceurMeteorite extends Deplaceur {

    private static int num_tour_de_boucle;
    private static double xmove;
    private static double ymove;

    public DeplaceurMeteorite(Sujet s, Monde m) {
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
        num_tour_de_boucle = Variables.NEW_VITESSE;
        xmove = Variables.XMOVE_BASE;
        ymove = Variables.YMOVE_BASE;
    }

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

