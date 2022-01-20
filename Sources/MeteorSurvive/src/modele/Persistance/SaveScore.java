package modele.Persistance;

import javafx.collections.transformation.SortedList;
import modele.Score.ResultatScore;

/**
 * Interface Utilise pour la persistance en sauvegardes des données
 */
public interface SaveScore {

    /**
     * methode de sauvegarde des données
     * @param allscore tous les scores triée
     */
    public void SaveScore(SortedList<ResultatScore> allscore) throws Exception;
}
