package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

public class ItemAugmenterSaut extends Item implements IBonus {

    public ItemAugmenterSaut(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/bonus-item_002.png")));
    }

    @Override
    public void addBonus(Dino d, int value) {
        d.setHauteurSaut(45);
        d.setDoubleSaut(true);

    }

    @Override
    public String toString() {
        return "ItemAugmenterSaut{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

}
