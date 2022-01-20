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
package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Contenant toutes les Variables Static de l'application
 */
public class Variables extends Sujet {

    public static String nomJoueur;
    public static Long lastScore;

    /*Variables creation meteorite*/
    public static int more_meteorite = 0;
    public static int lenteur_jeu; // = 5 -> lent ; = 0 -> rapide
    public static int temoin = 0;

    /*Variables creation de pet*/
    public static int NB_METEORITES_POUR_UN_PET = 10;
    public static int NB_PETS_DEBUT = 5;
    public static int NB_METEORITES_POUR_UN_ITEM = 10;

    /* Variables deplacement meteorites */
    public static final double XMOVE_BASE = 4d;
    public static final double YMOVE_BASE = -0.8d;

    // toutes les NEW_VITESSSE tours de boucle, on augmente la vitesse de chute des meteorites;
    public static final int NEW_VITESSE = 100000;


}
