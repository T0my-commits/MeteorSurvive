package modele.Score;

import modele.Boucleur.Boucleur;
import modele.Observateur;

public class Score implements Observateur {

    private long score;

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
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
