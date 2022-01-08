package modele.Deplaceur;

import modele.Monde;
import modele.Objet.Meteorite;
import modele.Objet.Objet;
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
        for(Objet o : allObjet){
            o.setPosY(o.getPosY() + 1d);
            System.out.println(o);
        }
    }


}

