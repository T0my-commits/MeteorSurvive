package view;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import modele.Colisionneur.Colisionneur;
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
        manager.getMonde().getDino().setPosY(535d);
        getScene();
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        controledep.setText("");
        System.out.println("La touche " + keyEvent.getCode() + " a ete pressee");
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
                manager.peter(manager.getMonde().getDino().getPosX(), manager.getMonde().getDino().getPosY(), 1);
            }
        }
    }

    public void getScene() {
        ImageView i = new ImageView();
        i.setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/sol.png"));
        i.xProperty().bind(manager.getMonde().getSol().posXProperty());
        i.yProperty().bind(manager.getMonde().getSol().posYProperty());

        fenetrejeu.getChildren().add(i);
        AnchorPane.setBottomAnchor(i, 1.0);


        manager.getMeteorite().addListener((InvalidationListener) observable -> {
            for (var o : manager.getMeteorite()) {
                if (!o.isAffiche()) {
                    System.out.println("Nouvel objet : " + o);
                    o.getImageView().setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
                    o.getImageView().xProperty().bind(o.posXProperty());
                    o.getImageView().yProperty().bind(o.posYProperty());
                    fenetrejeu.getChildren().add(o.getImageView());
                    o.setAffiche(true);
                    allMeteorite.put(o, o.getImageView());
                }

                if (Colisionneur.isColision(o, manager.getMonde(), o.getPosX(), o.getPosY())) {
                    /*int index = fenetrejeu.getChildren().indexOf(o.getImageView());
                    o.setPosY(o.getPosY() + 20d);
                    ((ImageView) fenetrejeu.getChildren().get(index)).setImage(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/explosion_001.png"));

                    final Animation animation = new Transition() {
                        {
                            setCycleDuration(Duration.millis(1000d));
                        }
                        @Override
                        protected void interpolate(double v) {
                            fenetrejeu.getChildren().remove(o.getImageView());
                        }
                    };
                    animation.play();*/
                    fenetrejeu.getChildren().remove(o.getImageView());
                }
                else {

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
                    allPets.put(o, o.getImageView());
                }
        }


        });
    }
}
