package modele.Boucleur;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class BoucleurMeteorite extends Boucleur{

    public BoucleurMeteorite(){System.out.println("METEORITE");}

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
                    sleep(350);
                    Platform.runLater(notifieur);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }



        }
    }
}
