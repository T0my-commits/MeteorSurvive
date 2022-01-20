package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Objet.Entite;

/**
 * Classe Item qui sert a decrire un item et sont comportement
 */

public class Item extends Entite {
    /**
     * Etat de l'item
     */
    private boolean isEnable;

    /**
     * Information si l'item doit tomber ou non
     */
    protected boolean isStatique;

    /**
     * Constructeur d'item
     * @param x Position en X
     * @param y Position en Y
     * @param r Hitbox de l'item
     */
    public Item(double x, double y, Rectangle r) {
        super(x, y, r);
        isEnable = true;
        isStatique = false;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEtat(boolean enable) {
        isEnable = enable;
    }

    @Override
    public String toString() {
        return "Item {"+posX.get()+" ; "+posY.get()+"}";
    }

    public boolean isStatique() {
        return isStatique;
    }

}
