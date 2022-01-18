package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.Manager.Manager;
import modele.Manager.ManagerMenu;
import modele.Objet.Shoot;
import modele.Score.ResultatScore;

public class FenetreMenu {

    //@FXML
    //public ImageView bg;

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

    manager = new ManagerMenu();
        for (ResultatScore r :manager.getBestScores()
             ) {

            if(r.getNomJoueur() == null) nom = new Text("T-Rex");
            else nom = new Text(r.getNomJoueur());
            nom.setFont(Font.font("Impact", 20));
            nom.setStroke(Color.WHITE);

            score = new Text(String.valueOf(r.getScore()));
            score.setFont(Font.font("Impact", 20));
            score.setStroke(Color.WHITE);


            tableauScore.add(nom, 0,i);
            tableauScore.add(score, 1,i);


            i++;
        }

    }



}
