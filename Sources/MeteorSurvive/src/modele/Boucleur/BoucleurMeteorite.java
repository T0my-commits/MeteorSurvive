package modele.Boucleur;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class BoucleurMeteorite extends Boucleur{

    public BoucleurMeteorite(){}

    @Override
    public void run() {
        Runnable notifieur = new Runnable() {
            @Override
            public void run() {
                notifier();
            }
        };

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(notifieur);
        }
    }
}
