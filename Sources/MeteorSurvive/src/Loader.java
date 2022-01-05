import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Loader extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent racine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/FenetreJeu.fxml")));
            Scene scene = new Scene(racine);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
}
