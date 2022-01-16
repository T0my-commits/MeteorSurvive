package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Manager.Manager;
import modele.Objet.*;
import modele.Objet.Item.Item;
import modele.Objet.Item.ItemRechargePet;
import modele.Objet.Item.ItemRechargeVie;

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
    Manager manager;


    public Monde(Manager m) {
        dino = new Dino(600,0);
        allEntite = new ArrayList<>();
        allEntite.add(dino);
        sol = new Sol();
        allEntite.add(sol);
        allEntite.add(new Mur(1269, 0));
        allEntite.add(new Mur(-2, 0));
        manager = m;

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

    public List<Mur> getWall(){
        List<Mur> murs = new ArrayList<>();
        for (Entite e: getAllEntite()
             ) {
            if (e instanceof Mur)
                murs.add((Mur) e);
        }
        return murs;
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
        if (getDino().getPets() > 0) {
            Pet p = new Pet(x, y);
            listPets.add(p);
            allEntite.add(p);
            getDino().setPet(getDino().getPets() - 1);
        }
    }

    public void addItemRechargePet(double x, double y) {
        Item i = new ItemRechargePet(x, y, new Rectangle(x, y, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    public void addItemVie(double posX, double posY) {
        Item i = new ItemRechargeVie(posX, posY, new Rectangle(posX, posY, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    public ObservableList<Item> getItems() {
        return listItem;
    }

    public void addBonus(IBonus bonus) {
        bonus.addBonus(getDino(), 1);
    }

    public void removeEntite(Entite e) {
        allEntite.remove(e);
        e.setPosX(-8000);
    }

    public void infligerDegat(Meteorite m){
        dino.setDegat();
        m.setEtat(false);
        if(dino.getPdv() <= 0){
            manager.arretPartie();
        }
    }

}
