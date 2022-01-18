package modele.Manager;

import javafx.collections.ObservableList;
import modele.Bonus.IBonus;
import modele.Boucleur.Boucleur;
import modele.Boucleur.BoucleurJeu;
import modele.Boucleur.BoucleurMeteorite;
import modele.Deplaceur.*;
import modele.Loader.Loader;
import modele.Monde;
import modele.Objet.*;
import modele.Objet.Item.Item;
import modele.Score.GestionnaireScore;
import modele.Score.Score;
import modele.createur.CreateurItem;
import modele.createur.CreateurMeteorite;
import modele.createur.CreateurPet;

import java.io.IOException;

public class Manager {
    Monde monde;
    BoucleurJeu boucleur;
    Thread threadJeu;
    BoucleurMeteorite boucleM;
    Thread threadBoucleM;
    DeplaceurBasePerso deplaceurBasePerso;
    Deplaceur deplaceurMeteorite;
    Deplaceur deplaceurPet;
    Deplaceur deplaceurItem;
    GestionnaireScore score;

    public Manager() {
        Boucleur.setGameOver(false);
        monde = new Monde(this);
        boucleur = new BoucleurJeu();
        boucleM = new BoucleurMeteorite();
        deplaceurMeteorite = new DeplaceurMeteorite(boucleur, monde);
        deplaceurPet = new DeplaceurPet(boucleur, monde);
        deplaceurBasePerso = new DeplaceurBasePerso(boucleur, monde);
        deplaceurItem = new DeplaceurItem(boucleur, monde);

        threadJeu =  new Thread(boucleur);
        threadJeu.start();

        threadBoucleM = new Thread(boucleM);
        threadBoucleM.start();

        new CreateurMeteorite(monde, boucleM);
        //new CreateurItem(monde, boucleM);
        new CreateurPet(monde, boucleM);

        score = new GestionnaireScore(boucleur);

    }

    public ObservableList<Meteorite> getMeteorite(){
        return monde.getMeteorite();
    }

    public ObservableList<Pet> getPets(){
        return monde.getPets();
    }

    public ObservableList<Item> getItems() {
        return monde.getItems();
    }

    public Monde getMonde() { return monde; }

    public Deplaceur getDeplaceurDino() {
        return deplaceurBasePerso;
    }

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

    public void creerItemRechargePet(double x, double y) {
        monde.addItemRechargePet(x, y);
    }

    public void arretPartie(){

        Boucleur.setGameOver(true);

        threadJeu.interrupt();
        threadBoucleM.interrupt();
        System.out.println(("/*/*/*//*/*/*/*/*/"));
        score.SauvegarderScore();

        try {
            Loader.gestionnaireJeu.secondStage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sauter(){
        deplaceurBasePerso.sauter();
    }

}
