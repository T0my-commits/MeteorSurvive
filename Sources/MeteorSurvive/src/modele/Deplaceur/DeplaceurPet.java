package modele.Deplaceur;

import modele.Colisionneur.ColisionneurPet;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Objet.Pet;
import modele.Sujet;

import java.util.List;
import java.util.Random;

/**
 * Classe qui gere le deplacement des Meteorites, herite de Deplaceur
 */
public class DeplaceurPet extends Deplaceur {

    /**
     * Constructeur d'un DeplaceurMeteorite
     * @param s Boucle qui avertira quand faire le deplacement
     * @param m Monde où le deplacement doit être applique
     */
    public DeplaceurPet(Sujet s, Monde m) {
        setBoucleur(s);
        setMonde(m);
        s.attacher(this);
    }

    /**
     * Methode qui deplacera les Pets a chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {
        List<Pet> allPets = getMonde().getPets();
        List<Meteorite> allMeteorites = getMonde().getMeteorite();

        for(Pet o : allPets) {
            for (Meteorite m : allMeteorites) {
                if (ColisionneurPet.OnMeteorite(m, o)) {
                    if (o.isEnable()) {
                        // on fais spawn un item au hasard (60%), ou pas d'item du tout (40%);
                        if (new Random().nextInt(100) > 40) {
                            final int NB_TYPES_ITEMS = 3;
                            int random = new Random().nextInt(NB_TYPES_ITEMS);
                            switch (random) {
                                //case 0 -> getMonde().addItemRechargePetDino(m.getPosX(), m.getPosY());
                                case 1 -> getMonde().addItemVie(m.getPosX(), m.getPosY());
                                case 2 -> getMonde().addItemAugmenterSaut(m.getPosX(), m.getPosY());
                            }
                        }
                    }
                    o.setEtat(false);
                    m.setEtat(false);
                    getMonde().removeEntite(m);
                    getMonde().removeEntite(o);
                }
            }
            o.setPosY(o.getPosY() - 1d);
        }
    }
}
