package modele.Deplaceur;

import modele.Boucleur.BoucleurJeu;
import modele.Colisionneur.ColisionneurDino;
import modele.GestionnaireJeu;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Sujet;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 10;
    private int gravite;
    private int direction;
    int i =0;

    public DeplaceurBasePerso(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        gravite = 10;
    }

    /**
     * Défini une nouvelle position pour le dino
     */
    public void setPosition(Entite o, double i, double y) {
        // --------------------- si aucune collision, on dépace le dino
        o.setPosX(i);
        o.setPosY(y);
        // sinon pas de déplacement
    }

    public void deplacerDroite(){
        if(ColisionneurDino.OnGround(getMonde())) gravite = 0;
        else gravite = 10;
        direction = 2;
        //getMonde().getDino().setPosX(getMonde().getDino().getPosX()+10);
        //getMonde().getDino().setPosY(getMonde().getDino().getPosY()+gravite);
    }

    public void deplacerGauche(){
        if(ColisionneurDino.OnGround(getMonde())) gravite = 0;
        else gravite = 10;
        direction = -2;

        //getMonde().getDino().setPosX(getMonde().getDino().getPosX()-10);
        //getMonde().getDino().setPosY(getMonde().getDino().getPosY()+gravite);

    }


    @Override
    public void update() {

        Dino d = getMonde().getDino();
        d.updateX(direction);
        if(!ColisionneurDino.OnGround(getMonde())){
            d.updateY(gravite);
        }
        //d.setPosX(d.getPosX()+direction);
        //d.setPosY(d.getPosY()+gravite);
    }

}
