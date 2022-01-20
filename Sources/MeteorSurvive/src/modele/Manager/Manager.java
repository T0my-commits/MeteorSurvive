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

/**
 * Classe qui sert a gerer le deroulement d'une partie et l'interaction entre la vue et le modele
 */
public class Manager {
    /**
     * Monde du jeu
     */
    Monde monde;

    /**
     * Boucleur du jeu
     */
    BoucleurJeu boucleur;

    /**
     * Thread associe au boucleur du jeu
     */
    Thread threadJeu;

    /**
     * Boucle pour la creation de meteorite
     */
    BoucleurMeteorite boucleM;

    /**
     * Thread associe a la Boucle Meteorite
     */
    Thread threadBoucleM;

    /**
     * Deplaceur du personnage (dino)
     */
    DeplaceurBasePerso deplaceurBasePerso;

    /**
     * Deplaceur des meteorites
     */
    Deplaceur deplaceurMeteorite;

    /**
     * Deplaceur des Pets
     */
    Deplaceur deplaceurPet;

    /**
     * Deplaceur des Items
     */
    Deplaceur deplaceurItem;

    /**
     * Gere les scores
     */
    GestionnaireScore score;

    /**
     * Constructeur de Manager
     */
    public Manager() {

        Boucleur.setGameOver(false);// debut d'une nouvelle partie
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
        new CreateurItem(monde, boucleM);
        new CreateurPet(monde, boucleM);

        score = new GestionnaireScore(boucleur);

    }

    /**
     *
     * @return Liste Observable des meteorites
     */
    public ObservableList<Meteorite> getMeteorite(){
        return monde.getMeteorite();
    }

    /**
     * @return   Liste Observable des Pets
     */
    public ObservableList<Pet> getPets(){
        return monde.getPets();
    }

    /**
     * @return   Liste Observable des Items
     */
    public ObservableList<Item> getItems() {
        return monde.getItems();
    }

    public Monde getMonde() { return monde; }

    /**
     * Deplace le dino a droite
     */
    public void deplacerDinoDroite() {
        deplaceurBasePerso.deplacerDroite();

    }

    /**
     * Deplace le dino a gauche
     */
    public void deplacerDinoGauche() {

        deplaceurBasePerso.deplacerGauche();
    }

    /**
     * Fait peter le Dinosaure
     */
    public void creerPet() {
        monde.peter();
    }

    /**
     * gerer l'arret d'un patie, enregistre le score, arret des Thread etc
     */
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

    /**
     * Fait sauter le Dinosaure
     */
    public void sauter(){
        deplaceurBasePerso.sauter();
    }

}
