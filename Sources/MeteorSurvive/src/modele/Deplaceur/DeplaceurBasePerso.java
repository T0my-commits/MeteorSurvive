package modele.Deplaceur;

import modele.Boucleur.BoucleurJeu;
import modele.Colisionneur.Colisionneur;
import modele.Colisionneur.ColisionneurDino;
import modele.GestionnaireJeu;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Sujet;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 5;
    private int gravite;
    private int direction;
    int i =0;

    public DeplaceurBasePerso(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        gravite = 10;
    }

    public void deplacerDroite(){
        if(ColisionneurDino.OnGround(getMonde())) gravite = 0;
        else gravite = 10;
        direction = velocity;


    }

    public void deplacerGauche(){
        if(ColisionneurDino.OnGround(getMonde())) gravite = 0;
        else gravite = 10;
        direction = -velocity;

    }

    @Override
    public void update() {
        Dino d = getMonde().getDino();
        if(!ColisionneurDino.isColision(getMonde(), getMonde().getDino().getPosX()+direction,getMonde().getDino().getPosY())){
            d.updateX(direction);
        }
        if(!ColisionneurDino.OnGround(getMonde())){
            d.updateY(gravite);
        }
    }

}
