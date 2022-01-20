package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Classe d'une météorite, hérite de Entite
 */
public class Meteorite extends Entite{


    /**
     * Par defaut la météorite n'est pas affichée
     */
    private boolean isAffiche = false;

    /**
     * Information si la météorite est activée ou pas
     * par défaut la météorite est activé
     */
    private boolean isEnable = true;

    /**
     * Constructeur d'un météorite
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
