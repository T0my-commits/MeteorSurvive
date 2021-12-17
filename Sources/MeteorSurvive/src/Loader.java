import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Boucleur.BoucleurJeu;
import modele.Colisionneur.Colisionneur;
import modele.Deplaceur.DeplaceurBasePerso;
import modele.Deplaceur.DeplaceurMeteorite;
import modele.Manager.Manager;
import modele.Objet.Personnage;

public class Loader extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("FXML/FenetreJeu.fxml")); // getClass() peut etre null, il faut vérifier
        Scene scene = new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true); // on met la fenêtre en "plein écran"
        primaryStage.show();



    }
}
