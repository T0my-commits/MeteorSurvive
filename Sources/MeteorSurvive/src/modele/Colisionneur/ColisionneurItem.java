package modele.Colisionneur;

import modele.Objet.Dino;
import modele.Objet.Item.Item;

import java.util.List;

public class ColisionneurItem extends Colisionneur {

    public static Item GetItem(Dino d, List<Item> items) {
        for (Item i : items) {
            if (i.getHitbox().intersects(d.getHitbox().getBoundsInLocal()))
                return i;
        }
        return null;
    }
}
