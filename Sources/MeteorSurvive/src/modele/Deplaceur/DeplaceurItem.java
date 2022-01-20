package modele.Deplaceur;

import modele.Colisionneur.ColisionneurItem;
import modele.Monde;
import modele.Objet.Item.Item;
import modele.Sujet;

import java.util.List;

/**
 * Classe qui gere le deplacement des Items, herite de Deplaceur
 */
public class DeplaceurItem extends Deplaceur {

    /**
     * Gravite applique au Item
     */
    private final int GRAVITE;

    /**
     * Constructeur d'un DeplaceurItem
     * @param s Boucle qui avertira quand faire le deplacement
     * @param m Monde où le deplacement doit être applique
     */
    public DeplaceurItem(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        this.GRAVITE = 5;
    }

    /**
     * Methode qui deplacera les Items a chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {
        List<Item> p = getMonde().getItems();

        for (Item i : p) {
            if (!ColisionneurItem.OnGround(getMonde(), i) && !i.isStatique())
                i.updateY(GRAVITE);
        }
    }
}

