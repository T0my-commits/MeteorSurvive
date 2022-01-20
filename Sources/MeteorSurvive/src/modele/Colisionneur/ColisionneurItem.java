package modele.Colisionneur;

import modele.Objet.Dino;
import modele.Objet.Item.Item;

import java.util.List;

/**
 * Colisionneur qui gere uniquement les colision des Items, etends Colisionneur car il se sert des methodes de colisions basique
 */
public class ColisionneurItem extends Colisionneur {

    /**
     *  Methode qui gere la colision entre un Item et le Dino
     * @param d Dino dont on veut savoir si l'item est dessus
     * @param items Item dont on veut gerer la colision
     * @return retourn l'Item avec le quelle il y a une colision, null sinon
     */
    public static Item GetItem(Dino d, List<Item> items) {
        for (Item i : items) {
            if (i.getHitbox().intersects(d.getHitbox().getBoundsInLocal()))
                return i;
        }
        return null;
    }
}
