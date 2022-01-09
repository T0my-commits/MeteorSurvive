package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modele.Manager.Manager;
import modele.Objet.Meteorite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.sleep;


public class FenetreJeu {

    @FXML
    public AnchorPane fenetrejeu;

    Manager manager;

    Map<Meteorite, ImageView> allMeteorite = new HashMap<>();

    public void initialize()
    {
        manager = new Manager();
        //manager.creerObjetMeteorite(new Meteorite());
        getScene();



        /*
        while (manager.getMonde().getDino().getPointsDeVie() > 0) {
            // smthg
        }
        */
    }

    public void getScene(){

       /* for (Meteorite m : manager.getMeteorite()
             ) {
            ImageView i = new ImageView();
            i.setImage(new Image("file:///"+ System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
            i.xProperty().bind(m.posXProperty());
            i.yProperty().bind(m.posYProperty());
            fenetrejeu.getChildren().add(i);
        }
*/
        manager.getMeteorite().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                for (Meteorite m : manager.getMeteorite()
                ) {
                    if(!m.isAffiche()){
                        System.out.println("TEST");
                        ImageView i = new ImageView();
                        i.setImage(new Image("file:///"+ System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
                        i.xProperty().bind(m.posXProperty());
                        i.yProperty().bind(m.posYProperty());
                        fenetrejeu.getChildren().add(i);
                        m.setAffiche(true);
                        allMeteorite.put(m, i);
                    }

                }
            }
        });
    }
}
