package modele.Boucleur;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class BoucleurJeu extends Boucleur {


    public BoucleurJeu() {}

    @Override
    public void run() {
        Runnable notifieur = new Runnable() {
            @Override
            public void run() {
                notifier();
            }
        };
        // si le joueur veut bouger, on boucle
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(notifieur);
        }
    }
}
