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
package modele.createur;

import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

import java.util.Random;

/**
 * Classe de creation d'item, herite de Createur et implemente Observateur pour être notifier quand il faut creer un item
 */
public class CreateurItem extends Createur implements Observateur {

    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de meteorites avan de faire apparaitre un Item
     */
    private int nb_meteorites;

    /**
     * Constructeur d'un CreateurItem
     * @param m Monde où le createur vas creer
     * @param boucleM Boucleur qui notifiera pour l'update
     */
    public CreateurItem(Monde m, BoucleurMeteorite boucleM) {
        super(m);
        boucleur = boucleM;
        boucleur.attacher(this);
        nb_meteorites = Variables.NB_METEORITES_POUR_UN_ITEM; // variable qui changera en fonction de la difficulte choisi
    }

    /**
     * Redefinition de la methode d'update a chaque tour de boucle du Boucleur
     */
    @Override
    public void update() {
        if (nb_meteorites == 0) {
            creer();
            nb_meteorites = Variables.NB_METEORITES_POUR_UN_ITEM;
        }
        else
            nb_meteorites -= 1;
    }

    /**
     *
     * Methode qui defini comment un Item doit être cree
     */
    @Override
    public void creer() {
        double x = new Random().nextInt(1230);
        double y = new Random().nextInt(300)+300;

        m.addItemRechargePetDino(x, y);
    }
}
