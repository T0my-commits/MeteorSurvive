package modele.Deplaceur;

import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Objet.Entite;
import modele.Sujet;

import java.util.List;

public class DeplaceurMeteorite extends Deplaceur {
    int tmp;

    public DeplaceurMeteorite(Sujet s, Monde m) {
        tmp =0;
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
    }

    @Override
    public void update() {
        List<Meteorite> allMereorite = getMonde().getMeteorite();
        for(Meteorite e : allMereorite){
            if(Colisionneur.isColision(e, getMonde(), e.getPosX()+1,e.getPosY())) {
                getMonde().removeEntite(e);
            }
            else{
                e.updateY(5);
                e.updateX(-1);
            }


        }
    }


}

