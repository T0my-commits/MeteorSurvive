package modele.Persistance;

import modele.Score.ResultatScore;

import java.util.List;

/**
 * Interface Utilise pour la persistance en chargement des données
 */
public interface LoadScore {

    /**
     * methode de chargement des données
     * @return liste des scores
     */
    List<ResultatScore> LoadScore();
}
