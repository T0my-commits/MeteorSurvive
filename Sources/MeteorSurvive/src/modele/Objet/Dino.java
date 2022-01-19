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
    protected StringProperty nbPetsString = new SimpleStringProperty();
    public ObservableValue<String> nbPetsStringProperty() {
        System.out.println("Le nombre de pets actuel est " + nbPets.get());
        return nbPetsString;
    }


    public Dino(double x, double y) {
        super(x,y, new Rectangle(x,y,100,100));
        setPdv(3);
        setPet(5);
    }

    public void setDegat(){
        setPdv(getPdv()-1);
    }

    public void setPet(int val) {
        nbPets.set(val);
        nbPetsString.set(val+"");
    }

    public int getPets() {
        return nbPets.get();
    }

    public IntegerProperty petProperty() {
        return nbPets;
    }

    public IntegerProperty getNbPetsProperty() {
        return nbPets;
    }


}
