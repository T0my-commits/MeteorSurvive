package modele.Persistance;

import modele.Score.ResultatScore;

import java.util.List;

/**
 * Interface Utilise pour la persistance en chargement des donnees
 */
public interface LoadScore {

    /**
     * methode de chargement des donnees
     * @return liste des scores
     */
    List<ResultatScore> LoadScore();
}
