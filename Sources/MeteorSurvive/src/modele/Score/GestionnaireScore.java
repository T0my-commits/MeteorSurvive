/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
package modele.Score;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import modele.Boucleur.Boucleur;
import modele.Persistance.LoadScoreSerialization;
import modele.Persistance.SaveScoreSerialization;
import modele.Variables;

import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

/**
 * Classe qui sert a gerer les score deja fait et celle de la partie en cours
 */
public class GestionnaireScore {

    /**
     * Liste de tous les scores
     */
    private ObservableList<ResultatScore> allScores;

    /**
     * score de la partie en cours
     */
    private Score currentScore;

    /**
     * nom du joueur de la partie en cours
     */
    private String currentPlayer;

    /**
     * Constructeur d'un GestionnaireScore
     * @param b boucleur qui notifie pour augmenter le score
     */
    public GestionnaireScore(Boucleur b){
        allScores = FXCollections.observableArrayList(new LoadScoreSerialization().LoadScore());
        currentScore = new Score(b);
    }

    /**
     * methode servant a sauvegarder les scores
     */
    public void SauvegarderScore()  {
        currentPlayer= Variables.nomJoueur;
        Variables.lastScore=currentScore.getScore();
        allScores.add(new ResultatScore(currentScore.getScore(), currentPlayer));
        try {
            new SaveScoreSerialization().SaveScore(allScores.sorted(Comparator.comparing(ResultatScore::getScore)));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
