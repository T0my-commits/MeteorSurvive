package modele.Objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.shape.Rectangle;

public class Dino extends Entite {

    protected IntegerProperty pdv = new SimpleIntegerProperty();
    protected IntegerProperty nbPets = new SimpleIntegerProperty();

    public int getPdv(){return pdv.get();}
    public void setPdv(int value){pdv.set(value);}
    public IntegerProperty pdvProperty(){return pdv;}


    public Dino(double x, double y) {
        super(x,y, new Rectangle(x,y,100,100));
        setPdv(3);
    }

    public void setPet(int val) {
        nbPets.set(val);
    }

    public int getPets() {
        return nbPets.get();
    }

    public IntegerProperty getNbPetsProperty() {
        return nbPets;
    }


}
