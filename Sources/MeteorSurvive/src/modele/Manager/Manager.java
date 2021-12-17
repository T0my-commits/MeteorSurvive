package modele.Manager;

import modele.Boucleur.BoucleurJeu;
import modele.Deplaceur.DeplaceurMeteorite;
import modele.Monde;
import modele.Objet.Meteorite;

public class Manager {
    public Manager() {
        Monde m = new Monde();
        m.addObjet(new Meteorite());
        m.addObjet(new Meteorite(50,0));
        BoucleurJeu b = new BoucleurJeu();
        new Thread(b).start();
        DeplaceurMeteorite dep = new DeplaceurMeteorite(b, m);

    }


}
