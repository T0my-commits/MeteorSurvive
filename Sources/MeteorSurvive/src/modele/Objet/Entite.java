package modele.Objet;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Classe entite qui sert a decrire une entite et sont comportement;
 */
public abstract class Entite {

    /**
     * Possition en X
     * Propriete bindable
     */
    protected DoubleProperty posX = new SimpleDoubleProperty();
    public double getPosX(){return posX.get();}
    public void setPosX(double value){posX.set(value); hitbox.setX(value);}
    public DoubleProperty posXProperty(){return posX;}

    /**
     * Possition en Y
     * Propriete bindable
     */
    protected DoubleProperty posY = new SimpleDoubleProperty();
    public double getPosY(){return posY.get();}
    public void setPosY(double value){posY.set(value); hitbox.setY(value);}
    public DoubleProperty posYProperty(){return posY;}

    /**
     * Information si l'entite est deja affiche ou pas
     */
    private boolean isAffiche = false;

    /**
     * Image viex associe a l'entite
     */
    private ImageView imageView;

    /**
     * Hitbox de l'entite
     */
    private Rectangle hitbox;

    /**
     * Constructeur d'un entite
     * @param x Position en X
     * @param y Position en Y
     * @param hitbox Hitbox de l'item
     */
    public Entite(double x, double y, Rectangle hitbox) {
        this.posX.set(x);
        this.posY.set(y);
        this.hitbox=hitbox;
        imageView = new ImageView();
    }

    public Rectangle getHitbox() {
        return hitbox;
    }


    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * @param x nouvelle position en X de l'entite
     */
    public void updateX(double x){
        setPosX(getPosX()+x);
    }

    /**
     * @param x nouvelle position en Y de l'entite
     */
    public void updateY(double y){
        setPosY(getPosY()+y);
    }

    public boolean isAffiche() {
            return isAffiche;
        }
    public void setAffiche(boolean affiche) {
        isAffiche = affiche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entite)) return false;
        Entite entite = (Entite) o;
        return isAffiche == entite.isAffiche && Objects.equals(getPosX(), entite.getPosX()) && Objects.equals(getPosY(), entite.getPosY()) && Objects.equals(getImageView(), entite.getImageView()) && Objects.equals(getHitbox(), entite.getHitbox());
    }

    @Override
    public String toString() {
        return "Objet {" +
                "posx=" + posX +
                ", posY=" + posY +
                '}';
    }


}




