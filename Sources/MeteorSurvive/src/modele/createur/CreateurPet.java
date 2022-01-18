package modele.createur;

import modele.Boucleur.Boucleur;
import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;

public class CreateurPet extends Createur implements Observateur {

    private Sujet boucleur;
    private int nb_meteorite;
    private final int NB_METEORITES_POUR_UN_PET = 10;

    public CreateurPet(Monde m, Boucleur b) {
        super(m);
        boucleur = b;
        boucleur.attacher(this);
        nb_meteorite = NB_METEORITES_POUR_UN_PET;
    }

    @Override
    public void update() {
        // toutes les NB_METEORITES_POUR_UN_PET météorites, on crée un pet pour le joueur;
        if (nb_meteorite == 0) {
            this.creer(m);
            nb_meteorite = NB_METEORITES_POUR_UN_PET;
        }
        else  nb_meteorite -= 1;
    }

    @Override
    public void creer(Monde m) {
        m.getDino().setPet(m.getDino().getPets() + 1);
    }
}
