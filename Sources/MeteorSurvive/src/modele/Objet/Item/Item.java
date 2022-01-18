package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Objet.Entite;

public class Item extends Entite {

    private boolean isEnable;
    protected boolean isStatique;

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
