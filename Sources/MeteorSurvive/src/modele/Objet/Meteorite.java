package modele.Objet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Meteorite extends Entite {

    private boolean isAffiche = false;
    private boolean isEnable = true;

    public Meteorite(double x, double y){
        super(x,y, new Rectangle(x,y,100, 150));
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/meteorite.png")));

    }

    public Meteorite() {
        this(0d, 0d);
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
