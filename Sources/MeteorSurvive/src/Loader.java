import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.GestionnaireJeu;

public class Loader extends Application {
    @FXML
    public AnchorPane fenetrejeu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        new GestionnaireJeu(primaryStage);
    }

}