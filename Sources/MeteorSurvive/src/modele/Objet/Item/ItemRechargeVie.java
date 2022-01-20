/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
package modele.Objet.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Objet.Dino;


/**
 * Item qui recharge la vie du Dinosaure, Herite de Item et implemente IBonus
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
     * @param d Dinosaure affecte
     * @param value Nombre de vie a ajouter au Dinosaure
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
