package modele.Score;

import java.io.Serializable;


/**
 * Classe qui gerer un score deja fait, implemente Serializable pour la persistance
 */
public class ResultatScore implements Serializable {

    private long score;
    private String nomJoueur;
    static final long serialVersionUID = 8216180604790104263L;


    /**
     * Constructeur d'un ResultatScore
     * @param score
     * @param nomJoueur
     */
    public ResultatScore(long score, String nomJoueur) {
        this.score = score;
        this.nomJoueur = nomJoueur;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    @Override
    public String toString() {
        return "ResultatScore{" +
                "score=" + score +
                ", nomJoueur='" + nomJoueur + '\'' +
                '}';
    }

}
