import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.GestionnaireJeu;

import java.util.Objects;

public class Loader extends Application {

    public static Stage stage;

    public static GestionnaireJeu gestionnaireJeu;

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setResizable(false);
       stage = primaryStage;
       // new GestionnaireJeu(primaryStage, this);
    }



}
