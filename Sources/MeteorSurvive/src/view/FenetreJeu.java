package view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import modele.Shoot;

import java.awt.*;

public class FenetreJeu {

    //@FXML
    //public ImageView bg;

    @FXML
    public Text titre;

    @FXML
    public BorderPane mainBP;


    Shoot shoot = new Shoot();




    public void initialize()
    {
        //bg.setPreserveRatio(true);
        titre.setFont(new Font(50));


    }
}
