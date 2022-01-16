package modele.createur;

import modele.Boucleur.Boucleur;
import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;

public class CreateurPet extends Createur implements Observateur {

    private Sujet boucleur;
    private int nb_meteorite;

    public CreateurPet(Monde m, Boucleur b) {
        super(m);
        boucleur = b;
        boucleur.attacher(this);
        nb_meteorite = 5;
    }

    @Override
    public void update() {
        // toutes les 5 météorites, on crée un pet pour le joueur;
        if (nb_meteorite == 0) {
            this.creer(m);
            nb_meteorite = 5;
        }
        else  nb_meteorite -= 1;
    }

    @Override
    public void creer(Monde m) {
        m.getDino().setPet(m.getDino().getPets() + 1);
    }
}
