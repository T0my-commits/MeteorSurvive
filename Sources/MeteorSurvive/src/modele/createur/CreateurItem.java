package modele.createur;

import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

import java.util.Random;

/**
 * Classe de création d'item, hérite de Createur et implémente Observateur pour être notifier quand il faut creer un item
 */
public class CreateurItem extends Createur implements Observateur {

    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de météorites avan de faire apparaitre un Item
     */
    private int nb_meteorites;

    /**
     * Constructeur d'un CreateurItem
     * @param m Monde où le créateur vas creer
     * @param boucleM Boucleur qui notifiera pour l'update
     */
    public CreateurItem(Monde m, BoucleurMeteorite boucleM) {
        super(m);
        boucleur = boucleM;
        boucleur.attacher(this);
        nb_meteorites = Variables.NB_METEORITES_POUR_UN_ITEM; // variable qui changera en fonction de la difficulté choisi
    }

    /**
     * Redefinition de la méthode d'update a chaque tour de boucle du Boucleur
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
     * Methode qui defini comment un Item doit être créé
     */
    @Override
    public void creer() {
        double x = new Random().nextInt(1230);
        double y = new Random().nextInt(300)+300;

        m.addItemRechargePetDino(x, y);
    }
}
