package modele.Manager;

import modele.Persistance.LoadScoreSerialization;
import modele.Score.ResultatScore;

import java.util.List;

/**
 * Manager qui sert a gerer le menu principal et l'interaction entre la vue et le modele
 */
public class ManagerMenu {

    /**
     * Liste des meilleurs score deja fait
     */
    private List<ResultatScore> bestScores;

    /**
     * Constructeur du ManagerMenu
     */
    public ManagerMenu() {
        bestScores=new LoadScoreSerialization().LoadScore();
    }


    /**
     *
     * @return Liste des meilleurs scores
     */
    public List<ResultatScore> getBestScores() {
        return bestScores;
    }

}
