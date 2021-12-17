package modele.Boucleur;

import static java.lang.Thread.sleep;

public class BoucleurJeu extends Boucleur {

    private int moveX;
    private int moveY;

    public BoucleurJeu() {}

    @Override
    public void run() {
        // si le joueur veut bouger, on boucle
        while (true) {
            try {
                sleep(100);
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
