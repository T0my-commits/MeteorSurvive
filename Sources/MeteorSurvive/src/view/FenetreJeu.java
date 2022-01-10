package view;

import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modele.Manager.Manager;
import modele.Objet.Meteorite;
import modele.Objet.Pet;

import java.util.HashMap;
import java.util.Map;


import java.util.EventListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    public Text didacticiel;

    Map<Meteorite, ImageView> allMeteorite = new HashMap<>();
    Map<Pet, ImageView> allPets = new HashMap<>();

    public void initialize()
    {
        // création du monde, des objets, des déplaceurs, du collisionneur, etc.
        manager = new Manager();

        // binding des propriétés
        dino_view.xProperty().bind(manager.getMonde().getDino().posXProperty());
        dino_view.yProperty().bind(manager.getMonde().getDino().posYProperty());

        try {
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() -> didacticiel.setVisible(true), 0, 5, TimeUnit.SECONDS);
        } catch(Exception e) {
            System.out.println(e);
        }
        didacticiel.setVisible(false);

        // mise en place de la scene
        manager.getMonde().getDino().setPosY(350d);
        getScene();
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        controledep.setText("");
        System.out.println("La touche " + keyEvent.getCode() + " a ete pressee");
        switch (keyEvent.getCode()) {
            case D, RIGHT -> {
                manager.deplacerDino(manager.getMonde().getDino().getPosX() + 10, manager.getMonde().getDino().getPosY());
                dino_view.setScaleX(1f);
            }
            case Q, LEFT -> {
                manager.deplacerDino(manager.getMonde().getDino().getPosX() - 10, manager.getMonde().getDino().getPosY());
                dino_view.setScaleX(-1f);
            }

            case ENTER -> {
                manager.peter(manager.getMonde().getDino().getPosX(), manager.getMonde().getDino().getPosY(), 1);
            }
        }
    }

    public void getScene() {
        ImageView i = new ImageView();
        i.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png"));

        fenetrejeu.getChildren().add(i);
        AnchorPane.setBottomAnchor(i, 1.0);

        manager.getMeteorite().addListener((InvalidationListener) observable -> {
            for (var o : manager.getMeteorite()) {
                if (!o.isAffiche()) {
                    System.out.println("Nouvel objet : " + o);
                    ImageView i1 = new ImageView();
                    i1.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
                    i1.xProperty().bind(o.posXProperty());
                    i1.yProperty().bind(o.posYProperty());
                    fenetrejeu.getChildren().add(i1);
                    o.setAffiche(true);
                    allMeteorite.put(o, i1);
                }
            }
        });

        manager.getPets().addListener((InvalidationListener) observable -> {
            for (var o : manager.getPets()) {
                if (!o.isAffiche()) {
                    System.out.println("Nouvel objet : " + o);
                    ImageView i1 = new ImageView();
                    i1.setFitWidth(50);
                    i1.setFitHeight(50);
                    i1.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/pet_001.png"));
                    i1.xProperty().bind(o.posXProperty());
                    i1.yProperty().bind(o.posYProperty());
                    fenetrejeu.getChildren().add(i1);
                    o.setAffiche(true);
                    allPets.put(o, i1);
                }
            }
        });
    }
}
