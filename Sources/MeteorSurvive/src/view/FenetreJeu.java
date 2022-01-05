package view;

import javafx.fxml.FXML;
import javafx.scene.layout.*;
import modele.Manager.Manager;
import modele.Objet.Meteorite;

public class FenetreJeu {

    @FXML
    public AnchorPane id_fenetrejeu;

    public void initialize()
    {
        Manager manager = new Manager();
        manager.creerObjetMeteorite(new Meteorite());

        /*
        while (manager.getMonde().getDino().getPointsDeVie() > 0) {
            // smthg
        }
        */
    }
}
