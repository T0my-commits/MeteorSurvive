package modele;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Loader.Loader;

import java.io.IOException;
import java.util.Objects;

/**
 * Classe qui gere le fenetre de jeu
 */
public class GestionnaireJeu{

    /**
     * Stage de la fenetre
     */
    private final Stage stage;

    /**
     * Constructeur de GestionnaireJeu
     * @param primaryStage Stage de la fenêtre
     * @param l Loader de la fenetre
     */
    public GestionnaireJeu(Stage primaryStage, Loader l) throws IOException {
        stage = primaryStage;
        //setIsPlaying(false);
        Loader.gestionnaireJeu = this;
        secondStage();

    }

    /**
     * Methode de changement de scene vers la scene de jeu
     */
    public void firstStage() throws IOException {
        Parent racine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/FenetreJeu.fxml")));
        Scene scene = new Scene(racine);
        stage.setScene(scene);
        stage.setHeight(720);
        stage.setWidth(1280);
        stage.show();

        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    /**
     * Methode de changement de scene vers la scene du menu
     */
    public void secondStage() throws IOException {
        Parent racine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/FenetreMenu.fxml")));
        Scene scene = new Scene(racine);
        stage.setScene(scene);
        stage.setHeight(720);
        stage.setWidth(1280);
        stage.show();

        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }
}
