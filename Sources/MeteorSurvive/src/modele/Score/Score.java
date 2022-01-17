package modele.Score;

import modele.Boucleur.Boucleur;
import modele.Observateur;

public class Score implements Observateur {

    private static int score;

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Score.score = score;
    }

    public Score(Boucleur b){
        b.attacher(this);
        score =0;
    }

    @Override
    public void update() {
        setScore(getScore()+1);
    }
}
