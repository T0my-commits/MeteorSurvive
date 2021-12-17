package view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.Manager.Manager;
import modele.Objet.Shoot;

public class FenetreJeu {

    //@FXML
    //public ImageView bg;

    @FXML
    public Text titre;

    @FXML
    public BorderPane mainBP;

    @FXML
    public Button bouttondep;

    @FXML
    public TextField txtfield;

    Shoot shoot = new Shoot();

    public void initialize()
    {
        //bg.setPreserveRatio(true);
        titre.setFont(new Font(50));
        BorderPane.setAlignment(bouttondep, Pos.CENTER);
        Manager manager = new Manager();

    }




}
