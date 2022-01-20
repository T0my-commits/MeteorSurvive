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

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.Manager.Manager;
import modele.Objet.Entite;
import modele.Objet.Item.Item;
import modele.Objet.Item.ItemAugmenterSaut;
import modele.Objet.Item.ItemRechargePetDino;
import modele.Objet.Item.ItemRechargeVie;
import modele.Objet.Meteorite;
import modele.Objet.Pet;


import java.util.EventListener;

import static java.lang.Thread.sleep;


public class FenetreJeu implements EventListener {

    Manager manager;

    @FXML
    public AnchorPane fenetrejeu;
    @FXML
    public javafx.scene.control.TextField controledep;
    @FXML
    public ImageView dino_view;
    @FXML
    public Text pointVie;
    @FXML
    public HBox pdvBox;
    @FXML
    public Label nb_de_pets;
    @FXML
    public ImageView sol;

    public void initialize()
    {
        // creation du monde, des objets, des deplaceurs, du collisionneur, etc.
        manager = new Manager();

        // binding des proprietes
        dino_view.xProperty().bind(manager.getMonde().getDino().posXProperty());
        dino_view.yProperty().bind(manager.getMonde().getDino().posYProperty());
        nb_de_pets.textProperty().bind(manager.getMonde().getDino().nbPetsStringProperty());

        ImageView i = new ImageView();
        i.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png"));
        i.xProperty().bind(manager.getMonde().getSol().posXProperty());
        i.yProperty().bind(manager.getMonde().getSol().posYProperty());
        fenetrejeu.getChildren().add(i);
        AnchorPane.setBottomAnchor(i, 0.0);

        getScene();
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        controledep.setText("");
        switch (keyEvent.getCode()) {
            case D, RIGHT -> {
                manager.deplacerDinoDroite();
                dino_view.setScaleX(1f);
            }
            case Q, LEFT -> {
                manager.deplacerDinoGauche();
                dino_view.setScaleX(-1f);
            }
            case S, DOWN -> {
                manager.creerPet();
            }
            case SPACE -> {
                manager.sauter();
            }
        }
    }

    public void getScene() {
        pointVie.textProperty().bind(Bindings.convert(manager.getMonde().getDino().pdvProperty()));
        pointVie.setFont(Font.font("Impact", 20));

        ImageView i = new ImageView();
        i.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png"));
        i.xProperty().bind(manager.getMonde().getSol().posXProperty());
        i.yProperty().bind(manager.getMonde().getSol().posYProperty());
        fenetrejeu.getChildren().add(i);

        manager.getItems().addListener((InvalidationListener) observable -> {
            for (var item : manager.getItems()) {
                creerUIElement(item);
            }
        });

        manager.getMeteorite().addListener((InvalidationListener) observable -> {
            for (var o : manager.getMeteorite()) {
                creerUIElement(o);
            }
        });

        manager.getPets().addListener((InvalidationListener) observable -> {
            for (var o : manager.getPets()) {
                creerUIElement(o);
            }
        });
    }

    /**
     * Methode qui permet d'ajouter un nouvel UI Element a la scene
     * @param entite
     */
    private void creerUIElement(Entite entite) {
        String chemin = "";
        int h=0, w=0;

        // definition des paramètres;
        if (entite instanceof Meteorite) {
           h = 180; w = 125;
            //h = 150; w = 70;
        }
        if (entite instanceof Pet) {
            h = 50; w = 50;
        }

        if (entite instanceof Item) {
            h = 50; w = 50;

        }

        // creation d'un element dans la scene;
        if (!entite.isAffiche()) {
            entite.getImageView().setFitHeight(h);
            entite.getImageView().setFitWidth(w);
            entite.getImageView().xProperty().bind(entite.posXProperty());
            entite.getImageView().yProperty().bind(entite.posYProperty());
            fenetrejeu.getChildren().add(entite.getImageView());
            entite.setAffiche(true);
        }
    }
}
