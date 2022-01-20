package modele.Boucleur;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

/**
 * BoucleurJeu hérite de boucleur, il sera la pour gerer le taux de rafraichissment des images
 */
public class BoucleurJeu extends Boucleur {


    public BoucleurJeu() {System.out.println("JEU");}

    /**
     * faire un boucle de 10ms, il y a donc 100 rafraichissement par secondes
     */
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
            if(!isGameOver()){
                try {
                    sleep(10);
                    Platform.runLater(notifieur);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }


        }
    }
}
