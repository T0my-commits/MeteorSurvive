package modele.Objet.Item;

import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

public class ItemRechargePetDino extends Item implements IBonus {

    public ItemRechargePetDino(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        isStatique = true;
    }

    @Override
    public void addBonus(Dino d, int value) {
        d.setPet(d.getPets() + 1);
    }

    @Override
    public String toString() {
        return "ItemRechargePetDino {"+posX.get()+" ; "+posY.get()+"}";
    }

}
