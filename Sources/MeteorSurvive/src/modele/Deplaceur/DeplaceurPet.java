package modele.Deplaceur;

import modele.Monde;
import modele.Objet.Entite;
import modele.Objet.Pet;
import modele.Sujet;

import java.util.List;

public class DeplaceurPet extends Deplaceur {

    public DeplaceurPet(Sujet s, Monde m) {
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
    }

    @Override
    public void update() {
        List<Pet> allObjet = getMonde().getPets();
        for(Entite o : allObjet) {
            o.setPosY(o.getPosY() - 1d);
        }
    }
}
