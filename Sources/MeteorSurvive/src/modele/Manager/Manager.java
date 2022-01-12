package modele.Manager;

import javafx.collections.ObservableList;
import modele.Boucleur.BoucleurJeu;
import modele.Boucleur.BoucleurMeteorite;
import modele.Deplaceur.Deplaceur;
import modele.Deplaceur.DeplaceurBasePerso;
import modele.Deplaceur.DeplaceurMeteorite;
import modele.Deplaceur.DeplaceurPet;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Meteorite;
import modele.Objet.Entite;
import modele.createur.CreateurMeteorite;
import modele.Objet.Pet;

import java.util.List;

public class Manager {
    Monde monde;
    BoucleurJeu boucleur;
    BoucleurMeteorite boucleM;
    DeplaceurBasePerso deplaceurBasePerso;
    Deplaceur deplaceurMeteorite;
    Deplaceur deplaceurPet;

    public Manager() {
        monde = new Monde();

        boucleur = new BoucleurJeu();
        new Thread(boucleur).start();
        new CreateurMeteorite(monde);

        deplaceurMeteorite = new DeplaceurMeteorite(boucleur, monde);
        deplaceurPet = new DeplaceurPet(boucleur, monde);
        deplaceurBasePerso = new DeplaceurBasePerso(boucleur, monde);

    }

    /*public void creerObjetMeteorite(Meteorite o) {
        monde.addMeteorite(o);
        Deplaceur dep = new DeplaceurMeteorite(boucleur, monde);
    }*/

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

    public void peter(double x, double y, int pts) {
        monde.peter(x, y);
    }
}
