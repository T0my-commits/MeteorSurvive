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
