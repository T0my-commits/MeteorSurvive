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
import modele.Sujet;

import static java.lang.Thread.sleep;

/**
 * Classe qui defini une boucle de 1 seconde, sert de base pour les boucles suivantes
 * il herite de sujet car il doit etre observable pournotifier chaque tour de boucle
 * implementes Runnable pour pouvoir être lance dans un Thread
 */
public abstract class Boucleur extends Sujet implements Runnable {

    /**
     * savoir si le jeu est termine
     */
    private static boolean gameOver = false;

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Boucleur.gameOver = gameOver;
    }


    /**
     * Constructeur, ne necessite aucun parametre
     */
    public Boucleur() {}

    /**
     * Boucle qui est en focntionnement tant que le jeux n'est pas fini
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
            if (!isGameOver()) {
                try {
                    sleep(1000);
                    Platform.runLater(notifieur);// on lance la fonction quand cela sera possible
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

}
