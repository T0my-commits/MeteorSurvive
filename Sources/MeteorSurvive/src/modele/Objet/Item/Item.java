package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Objet.Entite;

public class Item extends Entite {

    private boolean isEnable;

    public Item(double x, double y, Rectangle r) {
        super(x, y, r);
        isEnable = true;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEtat(boolean enable) {
        isEnable = enable;
    }

}
