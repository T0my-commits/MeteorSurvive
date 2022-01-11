package modele;

import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import modele.Boucleur.BoucleurMeteorite;
import modele.Objet.*;
import modele.createur.CreateurMeteorite;

import java.util.*;

/**
 * Le role du maitre du jeu est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu;
 *  - la capacité d'appeler chaque éléments du jeu et les faire travailler ensemble;
 */
public class Monde{


    private List<Entite> allEntite;
    private Dino dino;

    private Sol sol;
    private ObservableList<Meteorite> listMeteorite = FXCollections.observableArrayList();
    private ObservableList<Pet> listPets = FXCollections.observableArrayList();




    public Monde() {
        dino = new Dino(600,0);
        allEntite = new ArrayList<>();
        allEntite.add(dino);
        sol = new Sol();
        allEntite.add(sol);

    }

    public ObservableList<Meteorite> getMeteorite(){
        return listMeteorite;
    }

    public ObservableList<Pet> getPets(){
        return listPets;
    }

    public void addMeteorite(Meteorite m){
        listMeteorite.add(m);
        allEntite.add(m);
    }

    public Dino getDino() {
        return dino;
    }

    public Sol getSol() {
        return sol;
    }

    public void setSol(Sol sol) {
        this.sol = sol;
    }

    public List<Entite> getAllEntite() {
        return allEntite;
    }

    public void AddEntite(Entite e) {
        allEntite.add(e);
    }

    public void delMeteorite(Meteorite m){
        listMeteorite.remove(m);
        delEntite(m);
    }

    public void delEntite(Entite e){
        allEntite.remove(e);
    }


    public void peter(double x, double y) {
        listPets.add(new Pet(x, y));
    }
}
