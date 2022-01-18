package modele.Manager;

import modele.Persistance.LoadScoreSerialization;
import modele.Score.ResultatScore;

import java.util.List;

public class ManagerMenu {

    private List<ResultatScore> bestScores;

    public ManagerMenu() {
        bestScores=new LoadScoreSerialization().LoadScore();
    }



    public List<ResultatScore> getBestScores() {
        return bestScores;
    }

    public void setBestScores(List<ResultatScore> bestScores) {
        this.bestScores = bestScores;
    }
}
