package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;


/**
 * Item qui recharge la vie du Dinosaure, Hérite de Item et implémente IBonus
 */
public class ItemRechargeVie extends Item implements IBonus {


    /**
     * Constructeur de ItemAugmenterSaut
     * @param x Position en X
     * @param y Position en Y
     * @param hitbox Hitbox de l'item
     */
    public ItemRechargeVie(double x, double y, Rectangle hitbox) {
        super(x, y, hitbox);
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/coeur.png")));
    }


    /**
     * Ajoute le Bonus au Dinosaure
     * @param d Dinosaure affecté
     * @param value Nombre de vie à ajouter au Dinosaure
     */
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
