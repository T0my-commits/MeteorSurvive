package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;
import modele.Objet.Item.Item;

public class ItemRechargeVie extends Item implements IBonus {
    public ItemRechargeVie(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
    }

    @Override
    public void addBonus(Dino d, int value) {
        if(d.getPdv()<10) d.setPdv(d.getPdv() + value);
    }
}
