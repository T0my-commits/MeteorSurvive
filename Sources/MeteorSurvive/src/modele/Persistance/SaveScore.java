package modele.Persistance;

import javafx.collections.transformation.SortedList;
import modele.Score.ResultatScore;

/**
 * Interface Utilise pour la persistance en sauvegardes des donnees
 */
public interface SaveScore {

    /**
     * methode de sauvegarde des donnees
     * @param allscore tous les scores triee
     */
    public void SaveScore(SortedList<ResultatScore> allscore) throws Exception;
}
