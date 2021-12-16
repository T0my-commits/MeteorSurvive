package modele.Deplaceur;

import modele.Boucleur.BoucleurJeu;
import modele.Objet.Objet;
import modele.Objet.Personnage;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 10;

    public DeplaceurBasePerso() {
        boucleur = new BoucleurJeu();
    }

    public void deplacer(Personnage pers, int x, int y) {
        pers.setPosx(x);
        pers.setPosY(y);
    }

    @Override
    void update() {

    }
}
