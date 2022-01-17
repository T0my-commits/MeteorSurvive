package modele.Persistance;

import javafx.collections.transformation.SortedList;
import modele.Score.ResultatScore;

public interface SaveScore {
    public void SaveScore(SortedList<ResultatScore> allscore) throws Exception;
}
