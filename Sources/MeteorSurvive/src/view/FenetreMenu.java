package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.Loader.Loader;
import modele.Manager.ManagerMenu;
import modele.Score.ResultatScore;
import modele.Variables;

import java.io.IOException;
import java.util.Objects;

public class FenetreMenu {


    @FXML
    public Text titre;

    @FXML
    public AnchorPane mainAnchor;

    @FXML
    public VBox vBox;

    @FXML
    public Button playButton;

    @FXML
    public GridPane tableauScore;

    @FXML
    public TextField nomJoueurTF;

    protected StringProperty nomJoueur = new SimpleStringProperty();
    public String getPosY(){return nomJoueur.get();}
    public void setnomJoueur(String value){nomJoueur.set(value);}
    public StringProperty nomJoueurProperty(){return nomJoueur;}

    DropShadow shadow = new DropShadow();
    ManagerMenu manager;

    public void initialize()
    {
    int i = 1;
    Text nom, score;
    vBox.setAlignment(Pos.CENTER);
    playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            playButton.setEffect(shadow);
        }

    });
    playButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            playButton.setEffect(null);
        }
    });
    nomJoueur.set(Variables.nomJoueur);
    nomJoueurTF.textProperty().bindBidirectional(nomJoueur);

    manager = new ManagerMenu();
        for (ResultatScore r :manager.getBestScores()
             ) {

            if(r.getNomJoueur() == null) nom = new Text("T-Rex");
            else nom = new Text(r.getNomJoueur());
            nom.setFont(Font.font("Impact", 25));
            nom.setStroke(Color.WHITE);

            score = new Text(String.valueOf(r.getScore()));
            score.setFont(Font.font("Impact", 25));
            score.setStroke(Color.WHITE);


            tableauScore.add(nom, 0,i);
            tableauScore.add(score, 1,i);


            i++;
        }

        if( Variables.lastScore!=null && Variables.lastScore>0 ){
            nom = new Text("Votre score :");
            nom.setFont(Font.font("Impact", 50));
            nom.setFill(Color.WHITE);
            nom.setStroke(Color.BLACK);

            score = new Text(String.valueOf(Variables.lastScore));
            score.setFont(Font.font("Impact", 50));
            score.setFill(Color.WHITE);
            score.setStroke(Color.BLACK);


            tableauScore.add(nom, 0,7);
            tableauScore.add(score, 1,7);

        }

    }


    public void handleButtonPress(ActionEvent actionEvent) throws IOException {
        Variables.nomJoueur = nomJoueur.get();
        Loader.gestionnaireJeu.firstStage();
    }
}
