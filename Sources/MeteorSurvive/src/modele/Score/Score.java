package modele.Score;

import modele.Boucleur.Boucleur;
import modele.Observateur;

/**
 * Classe representant le score courant, implemente observateur
 */

public class Score implements Observateur {

    /**
     * score courant
     */
    private long score;

    /**
     * Constructeur d'un score
     * @param b boucleur permettant d'incrementer le score
     */
    public Score(Boucleur b){
        b.attacher(this);
        score =0;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    /**
     * Augmente le score a chaque notification du boucleur
     */
    @Override
    public void update() {
        setScore(getScore()+1);
    }
}
