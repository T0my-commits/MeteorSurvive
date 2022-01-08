package modele.Boucleur;

import static java.lang.Thread.sleep;

public class BoucleurMeteorite extends Boucleur{

    public BoucleurMeteorite(){}

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5_000);
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
