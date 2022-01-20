package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Classe d'une meteorite, herite de Entite
 */
public class Meteorite extends Entite{


    /**
     * Par defaut la meteorite n'est pas affichee
     */
    private boolean isAffiche = false;

    /**
     * Information si la meteorite est activee ou pas
     * par defaut la meteorite est active
     */
    private boolean isEnable = true;

    /**
     * Constructeur d'un meteorite
     * @param x Position en X
     * @param y Position en Y
     */
    public Meteorite(double x, double y){
        super(x,y, new Rectangle(x,y,100, 150));
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/meteorite.gif")));

    }

    public boolean isAffiche() {
        return isAffiche;
    }

    public void setAffiche(boolean affiche) {
        isAffiche = affiche;
    }


    @Override
    public String toString() {
        return "Meteorite{ " + getPosX() +" / "+ getPosY()+" }";
    }

    public void setEtat(boolean b) {
        isEnable = b;
    }

    public boolean isEnable() {
        return isEnable;
    }
}
