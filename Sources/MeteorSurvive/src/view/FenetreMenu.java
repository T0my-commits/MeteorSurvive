
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

package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import modele.Objet.Pet;
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
    public GridPane tableauLastScore;

    @FXML
    public TextField nomJoueurTF;

    @FXML
    public Button difficultyButton;

    @FXML
    public TableView<ResultatScore> scoreTableView;



    final ObservableList<ResultatScore> allscores = FXCollections.observableArrayList();


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
    chargementdif();


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
    difficultyButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
                difficultyButton.setEffect(shadow);
            }
    });
    difficultyButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
                difficultyButton.setEffect(null);
            }
    });


    nomJoueur.set(Variables.nomJoueur);
    nomJoueurTF.textProperty().bindBidirectional(nomJoueur);

    manager = new ManagerMenu();
        for (ResultatScore r : manager.getBestScores()){
            allscores.add(r);
        }

    /*
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
        */
        if( Variables.lastScore!=null && Variables.lastScore>0 ){
            nom = new Text("Votre score :");
            nom.setFont(Font.font("Impact", 30));
            nom.setFill(Color.WHITE);
            nom.setStroke(Color.BLACK);

            score = new Text(String.valueOf(Variables.lastScore));
            score.setFont(Font.font("Impact", 30));
            score.setFill(Color.WHITE);
            score.setStroke(Color.BLACK);



            tableauLastScore.add(nom, 0,0);
            tableauLastScore.add(score, 1,0);

        }


        TableColumn joueurCol = new TableColumn("Joueur");
        joueurCol.setMinWidth(290);
        TableColumn scoreCol = new TableColumn("score");
        scoreCol.setMinWidth(290);
        scoreTableView.getColumns().add(joueurCol);
        scoreTableView.getColumns().add(scoreCol);

        scoreCol.setCellValueFactory(new PropertyValueFactory<ResultatScore, Long>("score"));
        joueurCol.setCellValueFactory(new PropertyValueFactory<ResultatScore, String>("nomJoueur"));

        scoreTableView.setItems(allscores);
        scoreCol.setSortType(TableColumn.SortType.DESCENDING);
        scoreTableView.getSortOrder().add(scoreCol);







    }


    public void playButtonPress(ActionEvent actionEvent) throws IOException {
        Variables.nomJoueur = nomJoueur.get();
        Loader.gestionnaireJeu.firstStage();
    }

    public void difficultyButtonPress(ActionEvent actionEvent) {

        ImageView newimage;
        String repCourant = "file:///" + System.getProperty("user.dir");

        if(difficultyButton.getText().equals("Bebe Diplodocus")){
            Variables.NB_METEORITES_POUR_UN_PET=25;
            Variables.NB_PETS_DEBUT = 3;
            Variables.NB_METEORITES_POUR_UN_ITEM = 20;
            newimage =new ImageView(new Image(repCourant +"/rsrc/media/velociraptor.png"));
            newimage.setFitWidth(60);
            newimage.setFitHeight(40.0);
            difficultyButton.setGraphic(newimage);
            difficultyButton.setText("Velociraptor");
        }
        else if(difficultyButton.getText() == "Velociraptor"){
            Variables.NB_METEORITES_POUR_UN_PET =50;
            Variables.NB_PETS_DEBUT = 0;
            Variables.NB_METEORITES_POUR_UN_ITEM = 30;
            newimage =new ImageView(new Image(repCourant +"/rsrc/media/tRex.png"));
            newimage.setFitWidth(40.0);
            newimage.setFitHeight(40.0);
            difficultyButton.setGraphic(newimage);
            difficultyButton.setText("T-Rex");
        }
        else if(difficultyButton.getText() == "T-Rex"){
            Variables.NB_METEORITES_POUR_UN_PET = 10;
            Variables.NB_PETS_DEBUT = 5;
            Variables.NB_METEORITES_POUR_UN_ITEM = 10;
            newimage =new ImageView(new Image(repCourant +"/rsrc/media/diplo.png"));
            newimage.setFitWidth(40.0);
            newimage.setFitHeight(40.0);
            difficultyButton.setGraphic(newimage);
            difficultyButton.setText("Bebe Diplodocus");
        }

    }

    public void chargementdif(){
        ImageView newimage;
        String repCourant = "file:///" + System.getProperty("user.dir");
        Variables.NB_METEORITES_POUR_UN_PET = 10;
        Variables.NB_PETS_DEBUT = 5;
        Variables.NB_METEORITES_POUR_UN_ITEM = 10;
        newimage =new ImageView(new Image(repCourant +"/rsrc/media/diplo.png"));
        newimage.setFitWidth(40.0);
        newimage.setFitHeight(40.0);
        difficultyButton.setGraphic(newimage);
        difficultyButton.setText("Bebe Diplodocus");
    }
}
