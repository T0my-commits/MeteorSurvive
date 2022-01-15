package modele.Manager;

import javafx.collections.ObservableList;
import modele.Bonus.IBonus;
import modele.Boucleur.BoucleurJeu;
import modele.Boucleur.BoucleurMeteorite;
import modele.Deplaceur.*;
import modele.Monde;
import modele.Objet.*;
import modele.Objet.Item.Item;
import modele.createur.CreateurMeteorite;
import modele.createur.CreateurPet;

public class Manager {
    Monde monde;
    BoucleurJeu boucleur;
    BoucleurMeteorite boucleM;
    DeplaceurBasePerso deplaceurBasePerso;
    Deplaceur deplaceurMeteorite;
    Deplaceur deplaceurPet;
    Deplaceur deplaceurItem;

    public Manager() {
        monde = new Monde();

        boucleur = new BoucleurJeu();
        new Thread(boucleur).start();
        new CreateurMeteorite(monde);
        new CreateurPet(monde);

        deplaceurMeteorite = new DeplaceurMeteorite(boucleur, monde);
        deplaceurPet = new DeplaceurPet(boucleur, monde);
        deplaceurBasePerso = new DeplaceurBasePerso(boucleur, monde);
        deplaceurItem = new DeplaceurItem(boucleur, monde);
    }

    public ObservableList<Meteorite> getMeteorite(){
        return monde.getMeteorite();
    }

    public ObservableList<Pet> getPets(){
        return monde.getPets();
    }

    public Monde getMonde() { return monde; }

    /**
     * Déplace le dino
     */
    public void deplacerDinoDroite() {
        deplaceurBasePerso.deplacerDroite();

    }

    public void deplacerDinoGauche() {

        deplaceurBasePerso.deplacerGauche();
    }

    public void creerPet(double x, double y) {
        monde.peter(x, y);
    }

    public void creerItem(double x, double y) {
        monde.addItemRechargePet(x, y);
    }

    public ObservableList<Item> getItems() {
        return monde.getItems();
    }
}
