package modele.Manager;

import javafx.collections.ObservableList;
import modele.Boucleur.BoucleurJeu;
import modele.Boucleur.BoucleurMeteorite;
import modele.Deplaceur.Deplaceur;
import modele.Deplaceur.DeplaceurBasePerso;
import modele.Deplaceur.DeplaceurMeteorite;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Meteorite;
import modele.Objet.Objet;
import modele.createur.CreateurMeteorite;

import java.util.List;

public class Manager {
    Monde monde;
    BoucleurJeu boucleur;
    BoucleurMeteorite boucleM;

    public Manager() {
        monde = new Monde();

        boucleur = new BoucleurJeu();
        new Thread(boucleur).start();
        new CreateurMeteorite(monde);
        Deplaceur dep = new DeplaceurMeteorite(boucleur, monde);
    }

    /*public void creerObjetMeteorite(Meteorite o) {
        monde.addMeteorite(o);
        Deplaceur dep = new DeplaceurMeteorite(boucleur, monde);
    }*/

    public ObservableList<Meteorite> getMeteorite(){
        return monde.getMeteorite();
    }


    public Monde getMonde() { return monde; }


}
