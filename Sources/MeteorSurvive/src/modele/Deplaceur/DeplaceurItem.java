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
package modele.Deplaceur;

import modele.Colisionneur.ColisionneurItem;
import modele.Monde;
import modele.Objet.Item.Item;
import modele.Sujet;

import java.util.List;

/**
 * Classe qui gere le deplacement des Items, herite de Deplaceur
 */
public class DeplaceurItem extends Deplaceur {

    /**
     * Gravite applique au Item
     */
    private final int GRAVITE;

    /**
     * Constructeur d'un DeplaceurItem
     * @param s Boucle qui avertira quand faire le deplacement
     * @param m Monde où le deplacement doit être applique
     */
    public DeplaceurItem(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        this.GRAVITE = 5;
    }

    /**
     * Methode qui deplacera les Items a chaque fois que le sujet le notifiera
     */
    @Override
    public void update() {
        List<Item> p = getMonde().getItems();

        for (Item i : p) {
            if (!ColisionneurItem.OnGround(getMonde(), i) && !i.isStatique())
                i.updateY(GRAVITE);
        }
    }
}

