/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
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
