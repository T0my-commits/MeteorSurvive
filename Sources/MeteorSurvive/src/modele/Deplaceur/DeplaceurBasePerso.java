package modele.Deplaceur;

import modele.Bonus.IBonus;
import modele.Boucleur.BoucleurJeu;
import modele.Colisionneur.Colisionneur;
import modele.Colisionneur.ColisionneurDino;
import modele.Colisionneur.ColisionneurItem;
import modele.GestionnaireJeu;
import modele.Monde;
import modele.Objet.Dino;
import modele.Objet.Entite;
import modele.Objet.Item.Item;
import modele.Sujet;

import java.util.List;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 5;
    private double gravite;
    private int direction;
    private int nb_double_saut = 5;

    int i = 0;

    public DeplaceurBasePerso(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        gravite = 9.81;
    }

    public void deplacerDroite(){
        direction = velocity;
    }

    public void deplacerGauche(){
        direction = -velocity;

    }

    public void sauter(){
        if(ColisionneurDino.OnGround(getMonde())){
            getMonde().getDino().setSaute(true);

            if (getMonde().getDino().isDoubleSaut()) {
                if (nb_double_saut >= 0) {
                    nb_double_saut -= 1;
                } else {
                    nb_double_saut = 5;
                    getMonde().getDino().setDoubleSaut(false);
                    getMonde().getDino().setHauteurSaut(40);
                }
            }

            i = getMonde().getDino().getHauteurSaut();
            System.out.println("La hauteur du saut : " + getMonde().getDino().getHauteurSaut());
        }
    }

    @Override
    public void update() {

        Dino d = getMonde().getDino();

        if(!ColisionneurDino.isColision(getMonde(), getMonde().getDino().getPosX()+direction,getMonde().getDino().getPosY())){
            d.updateX(direction);
        }

        if(getMonde().getDino().isSaute()){
            if(i>(i/2))d.updateY(-((i-(i/2))*(i-(i/2)))*gravite/200);
            else d.updateY(((i-(i/2))*(i-(i/2)))*gravite/200);

            i--;
            if(i==0) getMonde().getDino().setSaute(false);

        }


        if(!ColisionneurDino.OnGround(getMonde()) && i==0){
            d.updateY(15);

        }

        Item i = ColisionneurItem.GetItem(getMonde().getDino(), getMonde().getItems());
        if (i != null) {
            if (i.isEnable()) {
                getMonde().addBonus((IBonus) i);
                i.setEtat(false);
                getMonde().removeEntite(i);
            }
        }
    }
}
