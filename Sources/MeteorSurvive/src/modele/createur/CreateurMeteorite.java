package modele.createur;

import modele.Boucleur.BoucleurJeu;
import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Objet.Objet;
import modele.Observateur;
import modele.Sujet;

import java.util.Random;

public class CreateurMeteorite extends Createur implements Observateur {

    private Sujet boucleM;
    public CreateurMeteorite(Monde m) {
        super(m);
        boucleM = new BoucleurMeteorite();
        new Thread((Runnable) boucleM).start();
        boucleM.attacher(this);
    }

    @Override
    public void update() {
        this.creer(m);
    }

    @Override
    public void creer(Monde m) {
        m.addMeteorite(new Meteorite(new Random().nextInt(1000), -150));
    }

}
