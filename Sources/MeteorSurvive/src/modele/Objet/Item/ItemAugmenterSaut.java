package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

public class ItemAugmenterSaut extends Item implements IBonus {

    public ItemAugmenterSaut(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
    }

    @Override
    public void addBonus(Dino d, int value) {
        d.setHauteurSaut(45);
        d.setDoubleSaut(true);

    }

}
