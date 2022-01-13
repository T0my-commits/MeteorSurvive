package modele.Colisionneur;

import modele.Monde;
import modele.Objet.Item;
import modele.Objet.Meteorite;
import modele.Objet.Pet;

public class ColisionneurPet extends Colisionneur {

    public static boolean OnMeteorite(Meteorite m, Pet p) {
        return m.getHitbox().intersects(p.getHitbox().getBoundsInLocal());
    }

}