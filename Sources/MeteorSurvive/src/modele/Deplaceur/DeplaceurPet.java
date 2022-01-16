package modele.Deplaceur;

import modele.Colisionneur.ColisionneurPet;
import modele.Monde;
import modele.Objet.Meteorite;
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
        List<Pet> allPets = getMonde().getPets();
        List<Meteorite> allMeteorites = getMonde().getMeteorite();

        for(Pet o : allPets) {
            for (Meteorite m : allMeteorites) {
                if (ColisionneurPet.OnMeteorite(m, o)) {
                    if (!m.isEnable())
                        getMonde().addItemVie(m.getPosX(), m.getPosY());
                    m.setEtat(true);
                    getMonde().removeEntite(o);
                }
            }
            o.setPosY(o.getPosY() - 1d);
        }
    }
}
