package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;

/**
 * Item qui recharge les pets du Dinosaure, Hérite de Item et implémente IBonus
 */
public class ItemRechargePetDino extends Item implements IBonus {

    /**
     * Constructeur de ItemAugmenterSaut
     * @param x Position en X
     * @param y Position en Y
     * @param hitbox Hitbox de l'item
     */
    public ItemRechargePetDino(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/croquette_001.png")));
        isStatique = true;
    }


    /**
     * Ajoute le Bonus au Dinosaure
     * @param d Dinosaure affecté
     * @param value Nombre de pets à ajouter au Dinosaure
     */
    @Override
    public void addBonus(Dino d, int value) {
        d.setPet(d.getPets() + value);
    }

    @Override
    public String toString() {
        return "ItemRechargePetDino {"+posX.get()+" ; "+posY.get()+"}";
    }

}
