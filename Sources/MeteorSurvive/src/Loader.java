import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Colisionneur;
import modele.Deplaceur;
import modele.DeplaceurBasePerso;
import modele.Personnage;

public class Loader extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("FXML/FenetreJeu.fxml")); // getClass() peut etre null, il faut vérifier
        Scene scene = new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true); // on met la fenêtre en "plein écran"
        primaryStage.show();

        Personnage p1 = new Personnage(0,0,3);
        System.out.println(p1);
        DeplaceurBasePerso d = new DeplaceurBasePerso();
        d.deplacer(p1, 10 , 10);
        System.out.println(p1);
        Personnage p2 = new Personnage(10,10,3);
        Colisionneur col = new Colisionneur();
        if(col.isCollision(p1,p2))p2.setPtdeVie(2);
        System.out.println(p2);

    }
}
