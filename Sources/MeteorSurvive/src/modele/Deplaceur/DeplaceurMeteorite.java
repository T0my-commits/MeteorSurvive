package modele.Deplaceur;

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
        List<Meteorite> allObjet = getMonde().getMeteorite();
        for(Entite o : allObjet){
            o.setPosY(o.getPosY() + 1d);
            o.setPosX(o.getPosX() - 0.2d);
        }
    }


}

