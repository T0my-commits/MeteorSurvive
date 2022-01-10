package modele.Objet;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import modele.hitbox.Hitbox;

import javax.net.ssl.HostnameVerifier;

/**
 * La classe Objet défini un template pour tout les autres objets;
 */
public abstract class Entite {
    // déclaration des attributs
    private String url_visuel; // l'url vers l'aspect de l'objet;
    protected DoubleProperty posX = new SimpleDoubleProperty();
    public double getPosX(){return posX.get();}
    public void setPosX(double value){posX.set(value);}
    public DoubleProperty posXProperty(){return posX;}

    protected DoubleProperty posY = new SimpleDoubleProperty();
    public double getPosY(){return posY.get();}
    public void setPosY(double value){posY.set(value);}
    public DoubleProperty posYProperty(){return posY;}

    private boolean isAffiche = false;

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    private Hitbox hitbox;

    public Entite(double x, double y, Hitbox hitbox) {
        this.posX.set(x);
        this.posY.set(y);
        this.hitbox=hitbox;
    }


    public boolean isAffiche() {
        return isAffiche;
    }

    public void setAffiche(boolean val) {
        isAffiche = val;
    }

    @Override
    public String toString() {
        return "Objet {" +
                "posx=" + posX +
                ", posY=" + posY +
                '}';
    }


}
