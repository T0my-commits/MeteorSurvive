package modele.Objet;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * La classe Objet défini un template pour tout les autres objets;
 */
public abstract class Entite {
    // déclaration des attributs
    private String url_visuel; // l'url vers l'aspect de l'objet;
    protected DoubleProperty posX = new SimpleDoubleProperty();
    protected DoubleProperty posY = new SimpleDoubleProperty();
    protected DoubleProperty pointsdevie = new SimpleDoubleProperty();
    private boolean isAffiche = false;

    private static double gravite = 0.002d;
    private static double vitesse = 0.01d;


    public Entite(double x, double y, int pointsdevie) {
        this.posX.set(x);
        this.posY.set(y);
        this.pointsdevie.set(pointsdevie);
    }

    public double getPosX(){return posX.get();}
    public void setPosX(double value){posX.set(value);}
    public DoubleProperty posXProperty(){return posX;}

    public double getPosY(){return posY.get();}
    public void setPosY(double value){posY.set(value);}
    public DoubleProperty posYProperty(){return posY;}

    public double getPointsDeVie(){return this.pointsdevie.get();}
    public void setPointsDeVie(double pointsDeVie){this.pointsdevie.set(pointsDeVie);}
    public DoubleProperty pointdevieProperty(){return this.pointsdevie;}

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
                ", PtdeVie=" + pointsdevie +
                '}';
    }


}
