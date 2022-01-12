package modele.Objet;

import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;

public class ItemRechargePet extends Item implements IBonus {
    public ItemRechargePet(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
    }

    @Override
    public void addBonus(Dino d, int value) {
        d.setPet(d.getPets() + value);
    }
}
