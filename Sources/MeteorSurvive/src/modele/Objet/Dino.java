package modele.Objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;

public class Dino extends Entite {

    protected IntegerProperty pdv = new SimpleIntegerProperty();
    public int getPdv(){return pdv.get();}
    public void setPdv(int value){pdv.set(value);}
    public IntegerProperty pdvProperty(){return pdv;}

    protected IntegerProperty nbPets = new SimpleIntegerProperty();
    public int getPets() {
        return nbPets.get();
    }
    public void setPet(int val) {
        nbPets.set(val);
    }

    private int hauteur_saut;
    private boolean isSaute; // est en train de sauter ?
    private boolean isDoubleSaut;

    public Dino(double x, double y) {
        super(x,y, new Rectangle(x,y,100,100));
        setPdv(3);
        setPet(5);
        hauteur_saut = 40;
        isSaute = false;
        isDoubleSaut = false;
    }

    public void setDegat(){
        setPdv(getPdv()-1);
    }

    public int getHauteurSaut() {
        return this.hauteur_saut;
    }

    public void setHauteurSaut(int valeur) {
        this.hauteur_saut = valeur;
    }

    public boolean isDoubleSaut() {
        return isDoubleSaut;
    }

    public void setDoubleSaut(boolean val) {
        //if (val) setHauteurSaut(60);
        //else setHauteurSaut(40);

        this.isDoubleSaut = val;
    }

    public boolean isSaute() {
        return isSaute;
    }

    public void setSaute(boolean valeur) {
        this.isSaute = valeur;
    }

}
