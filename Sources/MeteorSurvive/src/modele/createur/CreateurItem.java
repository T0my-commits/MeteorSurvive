package modele.createur;

import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

import java.util.Random;

public class CreateurItem extends Createur implements Observateur {

    private Sujet boucleur;
    private int nb_meteorites;

    public CreateurItem(Monde m, BoucleurMeteorite boucleM) {
        super(m);
        boucleur = boucleM;
        boucleur.attacher(this);
        nb_meteorites = Variables.NB_METEORITES_POUR_UN_ITEM;
    }

    @Override
    public void update() {
        if (nb_meteorites == 0) {
            creer(m);
            nb_meteorites = Variables.NB_METEORITES_POUR_UN_ITEM;
        }
        else
            nb_meteorites -= 1;
    }

    @Override
    public void creer(Monde m) {
        double x = new Random().nextInt(1230);
        double y = new Random().nextInt(300)+300;

        m.addItemRechargePetDino(x, y);
    }
}
