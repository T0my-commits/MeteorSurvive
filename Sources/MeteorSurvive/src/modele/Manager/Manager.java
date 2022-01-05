package modele.Manager;

import modele.Boucleur.BoucleurJeu;
import modele.Deplaceur.Deplaceur;
import modele.Deplaceur.DeplaceurBasePerso;
import modele.Deplaceur.DeplaceurMeteorite;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Meteorite;
import modele.Objet.Objet;

public class Manager {
    Monde monde;
    BoucleurJeu boucleur;

    public Manager() {
        monde = new Monde();

        monde.addObjet(new Dino(0,0,100));

        monde = new Monde();
        boucleur = new BoucleurJeu();
        new Thread(boucleur).start();
    }

    public void creerObjetMeteorite(Objet o) {
        monde.addObjet(o);
        Deplaceur dep = new DeplaceurMeteorite(boucleur, monde);
    }

    public void creerObjetDino(Objet o) {
        monde.addObjet(o);
        Deplaceur dep = new DeplaceurBasePerso();
    }

    public Monde getMonde() { return monde; }


}
