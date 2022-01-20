package modele.Boucleur;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

/**
 * BoucleurMeteorite herite de boucleur, il sera la pour gerer l'apparition de meteorites
 */
public class BoucleurMeteorite extends Boucleur{

    public BoucleurMeteorite(){System.out.println("METEORITE");}

    /**
     * faire un boucle de 450ms, on notifie les observateur toutes les 450ms de lancer leur methode updates
     */
    @Override
    public void run() {
        Runnable notifieur = new Runnable() {
            @Override
            public void run() {
                notifier();
            }
        };

        while (true) {
            if(!isGameOver()){
                try {
                    sleep(450);
                    Platform.runLater(notifieur);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }



        }
    }
}
