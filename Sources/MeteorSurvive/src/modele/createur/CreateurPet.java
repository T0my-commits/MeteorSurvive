package modele.createur;

import modele.Boucleur.Boucleur;
import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

/**
 * Classe de creation de Pet, herite de Createur et implemente Observateur pour être notifier quand il faut creer un Pet
 */
public class CreateurPet extends Createur implements Observateur {

    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de meteorites avan de creer un pet
     */
    private int nb_meteorite;

    /**
     * Constructeur d'un CreateurPet
     * @param m Monde où le createur vas creer
     * @param b Boucleur qui notifiera pour l'update
     */
    public CreateurPet(Monde m, Boucleur b) {
        super(m);
        boucleur = b;
        boucleur.attacher(this);
        nb_meteorite = Variables.NB_METEORITES_POUR_UN_PET;
    }

    /**
     * Redefinition de la methode d'update a chaque tour de boucle du Boucleur
     */
    @Override
    public void update() {
        // toutes les NB_METEORITES_POUR_UN_PET meteorites, on cree un pet pour le joueur;
        if (nb_meteorite == 0) {
            this.creer();
            nb_meteorite = Variables.NB_METEORITES_POUR_UN_PET;
        }
        else  nb_meteorite -= 1;
    }


    /**
     *
     * Methode qui defini comment un Pet doit être cree
     */
    @Override
    public void creer() {
        m.getDino().setPet(m.getDino().getPets() + 1);
    }
}
