package modele.Boucleur;

import modele.Sujet;

public abstract class Boucleur extends Sujet implements Runnable {

    private static boolean gameOver = false;

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Boucleur.gameOver = gameOver;
    }


    public Boucleur() {
    }

    @Override
    public void run() {

    }

}
