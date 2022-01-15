package view;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.Bonus.IBonus;
import modele.Colisionneur.Colisionneur;
import modele.Manager.Manager;
import modele.Objet.Item.Item;
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

    public void initialize()
    {
        // création du monde, des objets, des déplaceurs, du collisionneur, etc.
        manager = new Manager();

        // binding des propriétés
        dino_view.xProperty().bind(manager.getMonde().getDino().posXProperty());
        dino_view.yProperty().bind(manager.getMonde().getDino().posYProperty());

        // mise en place de la scene
        nb_de_pets.textProperty().bind(manager.getMonde().getDino().nbPetsStringProperty());
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
            case SPACE -> {
                manager.creerPet(manager.getMonde().getDino().getPosX(), manager.getMonde().getDino().getPosY());
            }
        }
    }

    public void getScene() {
        pointVie.textProperty().bind(Bindings.convert(manager.getMonde().getDino().pdvProperty()));
        pointVie.setFont(Font.font("Impact", 20));
        AnchorPane.setRightAnchor(pdvBox , 1.0);
        AnchorPane.setBottomAnchor(pdvBox, 1.0);

        ImageView i = new ImageView();
        i.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png"));
        i.xProperty().bind(manager.getMonde().getSol().posXProperty());
        i.yProperty().bind(manager.getMonde().getSol().posYProperty());
        fenetrejeu.getChildren().add(i);
        AnchorPane.setBottomAnchor(i, 0.0);

        manager.getItems().addListener((InvalidationListener) observable -> {
            for (Item item : manager.getItems()) {
                if (!item.isAffiche()) {
                    System.out.println("Nouvel objet : " + i);
                    item.getImageView().setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/coeur.png"));
                    item.getImageView().setFitWidth(50);
                    item.getImageView().setFitHeight(50);
                    item.getImageView().xProperty().bind(item.posXProperty());
                    item.getImageView().yProperty().bind(item.posYProperty());
                    fenetrejeu.getChildren().add(item.getImageView());
                    item.setAffiche(true);
                }
                if (Colisionneur.isColision(item, manager.getMonde(), item.getPosX(), item.getPosY())) {
                    manager.addBonus((IBonus) item);
                    //fenetrejeu.getChildren().remove(item.getImageView());
                }
            }
        });

        manager.getMeteorite().addListener((InvalidationListener) observable -> {
            for (var o : manager.getMeteorite()) {
                if (!o.isAffiche()) {
                    System.out.println("Nouvel objet : " + o);
                    o.getImageView().setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
                    o.getImageView().setFitHeight(160);
                    o.getImageView().setFitWidth(75);
                    o.getImageView().xProperty().bind(o.posXProperty());
                    o.getImageView().yProperty().bind(o.posYProperty());
                    fenetrejeu.getChildren().add(o.getImageView());
                    o.setAffiche(true);
                }
                if (Colisionneur.isColision(o, manager.getMonde(), o.getPosX(), o.getPosY())) {
                    fenetrejeu.getChildren().remove(o.getImageView());
                }
            }
        });

        manager.getPets().addListener((InvalidationListener) observable -> {
            for (Pet o : manager.getPets()) {
                if (!o.isAffiche()) {
                    System.out.println("Nouvel objet : " + o);
                    o.getImageView().setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/pet_001.png"));
                    o.getImageView().setFitWidth(50);
                    o.getImageView().setFitHeight(50);
                    o.getImageView().xProperty().bind(o.posXProperty());
                    o.getImageView().yProperty().bind(o.posYProperty());
                    fenetrejeu.getChildren().add(o.getImageView());
                    o.setAffiche(true);
                }
                if (Colisionneur.isColision(o, manager.getMonde(), o.getPosX(), o.getPosY())) {
                    fenetrejeu.getChildren().remove(o.getImageView());
                }
            }
        });
    }
}
