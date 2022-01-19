package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

public class ItemRechargeVie extends Item implements IBonus {

    public ItemRechargeVie(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/coeur.png")));
    }

    @Override
    public void addBonus(Dino d, int value) {
        if(d.getPdv()<10) d.setPdv(d.getPdv() + value);
    }

    @Override
    public String toString() {
        return "ItemRechargeVie{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
