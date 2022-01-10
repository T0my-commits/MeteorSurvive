package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Objet.Dino;
import modele.Objet.Meteorite;
import modele.Objet.Entite;
import modele.Objet.Pet;

import java.util.*;

/**
 * Le role du maitre du jeu est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu;
 *  - la capacité d'appeler chaque éléments du jeu et les faire travailler ensemble;
 */
public class Monde{
    private List<Entite> allObject;
    private Dino dino;
    private ObservableList<Meteorite> listMeteorite = FXCollections.observableArrayList();
    private ObservableList<Pet> listPets = FXCollections.observableArrayList();


    public Monde() {
        dino = new Dino(0,1,100);
        allObject = new ArrayList<>();

    }

    public ObservableList<Meteorite> getMeteorite(){
        return listMeteorite;
    }

    public ObservableList<Pet> getPets(){
        return listPets;
    }

    public void addMeteorite(Meteorite m){
        listMeteorite.add(m);
    }

    public Dino getDino() {
        return dino;
    }

    public void peter(double x, double y, int pts) {
        listPets.add(new Pet(x, y, pts));
    }
}
