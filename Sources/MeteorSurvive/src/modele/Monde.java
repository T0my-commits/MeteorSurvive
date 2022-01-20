/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import modele.Bonus.IBonus;
import modele.Manager.Manager;
import modele.Objet.*;
import modele.Objet.Item.Item;
import modele.Objet.Item.ItemAugmenterSaut;
import modele.Objet.Item.ItemRechargePetDino;
import modele.Objet.Item.ItemRechargeVie;

import java.util.*;

/**
 * Le role du Monde est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu;
 *  - la capacite d'appeler chaque elements du jeu et les faire travailler ensemble;
 */
public class Monde{

    /**
     * Liste de toutes les entitees
     */
    private final List<Entite> allEntite;

    /**
     * Dinosaure de la partie
     */
    private final Dino dino;

    /**
     * Sol du monde
     */
    private Sol sol;

    /**
     * Liste de toutes les meteorites
     */
    private final ObservableList<Meteorite> listMeteorite = FXCollections.observableArrayList();

    /**
     * Listes de tous les pets
     */
    private final ObservableList<Pet> listPets = FXCollections.observableArrayList();

    /**
     * Liste des tous les Items
     */
    private final ObservableList<Item> listItem = FXCollections.observableArrayList();
    Manager manager;


    /**
     * Constructeur de Monde
     * @param m manager a qui appartient le monde
     */
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

    /**
     * Fonction d'ajout d'une meteorite
     * @param m Meteorite a ajouter
     */
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

    /**
     * Fonction qui fait peter le Dinosaure
     */
    public void peter() {
        if (getDino().getPets() > 0) {
            Pet p = new Pet(dino.getPosX(), dino.getPosY());
            listPets.add(p);
            allEntite.add(p);
            getDino().setPet(getDino().getPets() - 1);
        }
    }

    /**
     * Fonction d'ajout d'une recharge de pets
     * @param x Position en X
     * @param y Position en Y
     */
    public void addItemRechargePetDino(double x, double y) {
        Item i = new ItemRechargePetDino(x, y, new Rectangle(x, y, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    /**
     * Fonction d'ajout d'une vie
     * @param posX Position en X
     * @param posY Position en Y
     */
    public void addItemVie(double posX, double posY) {
        Item i = new ItemRechargeVie(posX, posY, new Rectangle(posX, posY, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    /**
     * Fonction d'augmentation du saut
     * @param posX Position en X
     * @param posY Position en Y
     */
    public void addItemAugmenterSaut(double posX, double posY) {
        Item i = new ItemAugmenterSaut(posX, posY, new Rectangle(posX, posY, 25, 25));
        listItem.add(i);
        allEntite.add(i);
    }

    public ObservableList<Item> getItems() {
        return listItem;
    }

    public void addBonus(IBonus bonus) {
        bonus.addBonus(getDino(), 1);
    }

    /**
     * Fonction de suppression dans la liste des entitees d'une entite
     * @param e Entite a supprimer
     */
    public void removeEntite(Entite e) {
        allEntite.remove(e);
        e.setPosX(-8000);
    }

    /**
     * Fonction qui inflige des degats au Dinosaure et arrete la partie si il n'y a pas de vie
     * @param m
     */
    public void infligerDegat(Meteorite m) {
        dino.setDegat();
        m.setEtat(false);
        if (dino.getPdv() <= 0) {
            manager.arretPartie();
        }
    }
}
