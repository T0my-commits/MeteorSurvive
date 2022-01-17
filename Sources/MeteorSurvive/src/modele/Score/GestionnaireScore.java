package modele.Score;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import modele.Boucleur.Boucleur;
import modele.Persistance.LoadScoreSerialization;
import modele.Persistance.SaveScoreSerialization;

import java.util.List;
import java.util.SortedMap;

public class GestionnaireScore {

    private ObservableList<ResultatScore> allScores;
    private Score currentScore;
    private String currentPlayer;

    public GestionnaireScore(Boucleur b){
        allScores = FXCollections.observableArrayList(new LoadScoreSerialization().LoadScore());
        currentScore = new Score(b);
    }

    public void SauvegarderScore()  {
        allScores.add(new ResultatScore(currentScore.getScore(), currentPlayer));
        try {
            new SaveScoreSerialization().SaveScore(allScores.sorted());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
