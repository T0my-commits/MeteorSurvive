package modele.createur;

import modele.Boucleur.BoucleurMeteorite;
import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
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
        Meteorite tmp = new Meteorite(new Random().nextInt(1200) +10 , -150);
        while (Colisionneur.isColision(tmp, m, tmp.getPosX(), tmp.getPosY())){
            tmp = new Meteorite(new Random().nextInt(1200) +10 , -150);
        }
        m.addMeteorite(tmp);
    }

}
