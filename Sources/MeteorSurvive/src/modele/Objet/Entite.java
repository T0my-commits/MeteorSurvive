package modele.Objet;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * La classe Objet défini un template pour tout les autres objets;
 */
public abstract class Entite {
    // déclaration des attributs
    protected DoubleProperty posX = new SimpleDoubleProperty();
    public double getPosX(){return posX.get();}
    public void setPosX(double value){posX.set(value);}
    public DoubleProperty posXProperty(){return posX;}

    protected DoubleProperty posY = new SimpleDoubleProperty();
    public double getPosY(){return posY.get();}
    public void setPosY(double value){posY.set(value);}
    public DoubleProperty posYProperty(){return posY;}

    private boolean isAffiche = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entite)) return false;
        Entite entite = (Entite) o;
        return isAffiche() == entite.isAffiche() && Objects.equals(getPosX(), entite.getPosX()) && Objects.equals(getPosY(), entite.getPosY()) && Objects.equals(getHitbox(), entite.getHitbox());
    }


    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    private Rectangle hitbox;

    public Entite(double x, double y, Rectangle hitbox) {
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
