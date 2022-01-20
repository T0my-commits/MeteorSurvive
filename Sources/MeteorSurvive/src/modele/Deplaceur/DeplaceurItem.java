package modele.Deplaceur;

import modele.Colisionneur.ColisionneurItem;
import modele.Monde;
import modele.Objet.Item.Item;
import modele.Sujet;

import java.util.List;

/**
 * Classe qui gere le déplacement des Items, hérite de Déplaceur
 */
public class DeplaceurItem extends Deplaceur {

    /**
     * Gravité appliqué au Item
     */
    private final int GRAVITE;

    /**
     * Constructeur d'un DeplaceurItem
     * @param s Boucle qui avertira quand faire le déplacement
     * @param m Monde où le déplacement doit être applique
     */
    public DeplaceurItem(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        this.GRAVITE = 5;
    }

    /**
     * Méthode qui déplacera les Items à chaque fois que le sujet le notifiera
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

