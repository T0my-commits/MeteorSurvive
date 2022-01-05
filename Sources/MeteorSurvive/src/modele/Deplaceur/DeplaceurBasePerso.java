package modele.Deplaceur;

import modele.Boucleur.BoucleurJeu;
import modele.Objet.Objet;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 10;

    public DeplaceurBasePerso() {
       setBoucleur(new BoucleurJeu());
    }

    public void deplacer(Objet o, int x, int y) {
        o.setPosX(x);
        o.setPosY(y);
    }

    @Override
    public void update() {
        System.out.println("update base");
    }

}
