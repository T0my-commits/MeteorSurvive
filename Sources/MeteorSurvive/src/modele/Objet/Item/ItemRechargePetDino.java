package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

public class ItemRechargePetDino extends Item implements IBonus {

    public ItemRechargePetDino(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/croquette_001.png")));
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
