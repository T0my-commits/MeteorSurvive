package modele.Boucleur;

import static java.lang.Thread.sleep;

public class BoucleurJeu extends Boucleur {


    public BoucleurJeu() {}

    @Override
    public void run() {
        // si le joueur veut bouger, on boucle
        while (true) {
            try {
                sleep(10);
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
