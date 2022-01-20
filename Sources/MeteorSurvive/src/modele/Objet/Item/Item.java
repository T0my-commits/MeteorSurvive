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

import javafx.scene.shape.Rectangle;
import modele.Objet.Entite;

/**
 * Classe Item qui sert a decrire un item et sont comportement
 */

public class Item extends Entite {
    /**
     * Etat de l'item
     */
    private boolean isEnable;

    /**
     * Information si l'item doit tomber ou non
     */
    protected boolean isStatique;

    /**
     * Constructeur d'item
     * @param x Position en X
     * @param y Position en Y
     * @param r Hitbox de l'item
     */
    public Item(double x, double y, Rectangle r) {
        super(x, y, r);
        isEnable = true;
        isStatique = false;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEtat(boolean enable) {
        isEnable = enable;
    }

    @Override
    public String toString() {
        return "Item {"+posX.get()+" ; "+posY.get()+"}";
    }

    public boolean isStatique() {
        return isStatique;
    }

}
