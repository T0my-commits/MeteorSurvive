package modele;

import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import modele.Boucleur.BoucleurMeteorite;
import modele.Objet.Dino;
import modele.Objet.Meteorite;
import modele.Objet.Objet;
import modele.createur.CreateurMeteorite;

import java.util.*;

/**
 * Le role du maitre du jeu est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu ;
 *  - la capacité d'appeler chaque éléments du jeu et les faire travailler ensemble;
 */
public class Monde{
    private List<Objet> allObject;
    private Dino dino;
    private ObservableList<Meteorite> listMeteorite = FXCollections.observableArrayList();


    public Monde() {
        dino = new Dino(0,1,100);
        allObject = new ArrayList<>();

    }

    public ObservableList<Meteorite> getMeteorite(){
        //Si on a une liste avec tout les objet
        /*List<Meteorite> l = new ArrayList<>();
        for (Objet o: allObject
             ) {
            if(o instanceof Meteorite){
                l.add((Meteorite) o);
            }

        }*/
        return listMeteorite;
    }

    public void addMeteorite(Meteorite m){
        listMeteorite.add(m);
    }

    public Dino getDino() { return dino; }


}
