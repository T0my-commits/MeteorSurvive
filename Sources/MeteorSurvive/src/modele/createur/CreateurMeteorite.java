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

    // on passe more_meteorite tours de boucle avant de créer une nouvelle météorite;
    private static int more_meteorite = 0;
    private static int lenteur_jeu; // = 5 -> lent ; = 0 -> rapide
    private static int temoin = 0;

    public CreateurMeteorite(Monde m, BoucleurMeteorite b) {
        super(m);
        boucleM = b;
        boucleM.attacher(this);
    }

    @Override
    public void update() {
        switch (more_meteorite) {
            case 0: lenteur_jeu = 4; break;
            case 10, 20, 50, 80, 120, 250, 500, 1000, 1500, 2500:
                if (lenteur_jeu > 0)
                    lenteur_jeu -= 1;
                break;
        }


        if (temoin >= lenteur_jeu) {
            this.creer(m);
            temoin = 0;
        }
        else
            temoin += 1;

        if (lenteur_jeu != 0)
            more_meteorite += 1;
    }

    @Override
    public void creer(Monde m) {
        Meteorite tmp = new Meteorite(new Random().nextInt(1300) +10 , -150);
        while (Colisionneur.isColision(tmp, m, tmp.getPosX(), tmp.getPosY())){
            tmp = new Meteorite(new Random().nextInt(1200) +10 , -150);
        }
        m.addMeteorite(tmp);
    }

}
