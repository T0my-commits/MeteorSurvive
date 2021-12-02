package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import modele.Shoot;
import java.awt.Dimension;

public class FenetreJeu {

    @FXML
    public ImageView bg;

    Shoot shoot = new Shoot();
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    int height = (int)dimension.getHeight();
    int width  = (int)dimension.getWidth();

    public void initialize()
    {
        bg.setPreserveRatio(true);

        // on adapte la taille de l'image en fonction de l'écran
        // ne fonctionne pas
        if (height > width) bg.setFitWidth(width);
        else bg.setFitHeight(height);

    }
}
