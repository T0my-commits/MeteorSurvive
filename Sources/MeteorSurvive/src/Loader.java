import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loader extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("FXML/FenetreJeu.fxml")); // getClass() peut etre null, il faut vérifier
        Scene scene = new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
