package modele.Loader;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.GestionnaireJeu;

/**
 * Class qui sert a lancer l'application
 */
public class Loader extends Application {

    public static Stage stage;
    public static GestionnaireJeu gestionnaireJeu;

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setResizable(false);
       stage = primaryStage;
        new GestionnaireJeu(primaryStage, this);
    }

}
