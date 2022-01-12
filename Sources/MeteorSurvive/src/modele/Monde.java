package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import modele.Objet.*;

import java.util.*;

/**
 * Le role du maitre du jeu est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu;
 *  - la capacité d'appeler chaque éléments du jeu et les faire travailler ensemble;
 */
public class Monde{


    private final List<Entite> allEntite;
    private final Dino dino;

    private Sol sol;
    private final ObservableList<Meteorite> listMeteorite = FXCollections.observableArrayList();
    private final ObservableList<Pet> listPets = FXCollections.observableArrayList();
    private final ObservableList<Item> listItem = FXCollections.observableArrayList();

    // permet d'avoir un historique des Entite qui ont étés supprimées
    private final ObservableList<Entite> childrensRemoved = FXCollections.observableArrayList();

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

    public void peter(double x, double y) {
        Pet p = new Pet(x, y);
        listPets.add(p);
        allEntite.add(p);
    }

    public void addItemBonus(double x, double y) {
        Item i = new ItemRechargePet(x, y, new Rectangle(x, y, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    public ObservableList<Item> getItems() {
        return listItem;
    }

    public void removeEntite(Entite e) {
        assert false;
        childrensRemoved.add(e);
        allEntite.remove(e);
    }

    public ObservableList<Entite> getChildrendsRemoved() {
        return childrensRemoved;
    }

    public Entite getIndexOfLastChildenRemoved() {
        assert false;
        return childrensRemoved.get(childrensRemoved.size());
    }
}
