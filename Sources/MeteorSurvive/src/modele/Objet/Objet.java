package modele.Objet;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * La classe Objet défini un template pour tout les autres objets;
 */
public abstract class Objet {
    // déclaration des attributs
    private String url_visuel; // l'url vers l'aspect de l'objet;


    private IntegerProperty posX = new SimpleIntegerProperty();
    public int getPosX(){return posX.get();}
    public void setPosX(int value){posX.set(value);}
    public IntegerProperty posXProperty(){return posX;}

    private IntegerProperty posY = new SimpleIntegerProperty();
    public int getPosY(){return posY.get();}
    public void setPosY(int value){posY.set(value);}
    public IntegerProperty posYProperty(){return posX;}




}
