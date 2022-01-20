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
