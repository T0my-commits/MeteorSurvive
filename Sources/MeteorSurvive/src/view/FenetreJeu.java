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
import static java.lang.Thread.sleep;


public class FenetreJeu {

    @FXML
    public AnchorPane fenetrejeu;

    Manager manager;




    public void initialize()
    {
        manager = new Manager();
        //manager.creerObjetMeteorite(new Meteorite());
        getScene();


        System.out.println("*****************************************************");

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
        manager.getMeteorite().addListener((ListChangeListener.Change<? extends Meteorite> change) -> {
            while (change.next()){
                if(change.wasAdded()){
                    for (Meteorite m : change.getAddedSubList()
                         ) {
                        ImageView i = new ImageView();
                        i.setImage(new Image("file:///"+ System.getProperty("user.dir") + "/rsrc/media/meteorite.png"));
                        i.xProperty().bind(m.posXProperty());
                        i.yProperty().bind(m.posYProperty());
                        fenetrejeu.getChildren().add(i);
                    }
                }
            }
        });
    }
}
