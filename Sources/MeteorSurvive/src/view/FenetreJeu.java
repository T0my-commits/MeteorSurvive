package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import modele.Shoot;

public class FenetreJeu {

    @FXML
    public ImageView bg;
    @FXML
    public TitledPane titlepanetop;

    Shoot shoot = new Shoot();

    public void initialize()
    {
        bg.setPreserveRatio(true);
        titlepanetop.setText(shoot.getXvelocity());

    }
}
