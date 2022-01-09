package modele;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GestionnaireJeu implements Observateur {

    private final Stage stage;
    private boolean isPlaying; // true si en jeu, false si le joueur est sur le menu principal;

    public GestionnaireJeu(Stage primaryStage) throws IOException {
        stage = primaryStage;
        setIsPlaying(false);
        firstStage();
    }

    public void firstStage() throws IOException {
        Parent racine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/FenetreJeu.fxml")));
        Scene scene = new Scene(racine);
        stage.setScene(scene);

        stage.show();

        /*scene.setOnKeyPressed(event -> {
            System.out.println("La touche " + event.getCode() + " a ete pressee !");
        });*/
    }

    public void secondStage() {
        Label x = new Label("Second stage");
        VBox y = new VBox();

        y.getChildren().add(x);
        stage.setScene(new Scene(y, 300, 300));
        stage.show();
    }

    public void setIsPlaying(boolean val) {
        isPlaying = val;
    }

    @Override
    public void update() {
        if (!isPlaying) {
            setIsPlaying(true);
            secondStage();
        }
        else {
            setIsPlaying(false);
            try {firstStage();} catch (IOException e) {e.printStackTrace();}
        }
    }
}
