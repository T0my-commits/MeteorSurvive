/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
package modele.Objet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import modele.Variables;

/**
 * Classe du dinosaure, herite de Entite
 */
public class Dino extends Entite {

    /**
     * Point de vie du Dinosaure
     * Propriete bindable
     */
    protected IntegerProperty pdv = new SimpleIntegerProperty();
    public int getPdv(){return pdv.get();}
    public void setPdv(int value){pdv.set(value);}
    public IntegerProperty pdvProperty(){return pdv;}

    /**
     * Nombre de pets disponible
     * Propriete bindable
     */
    protected IntegerProperty nbPets = new SimpleIntegerProperty();
    protected StringProperty nbPetsString = new SimpleStringProperty();
    public ObservableValue<String> nbPetsStringProperty() {
        return nbPetsString;
    }

    /**
     * Hauteur du saut du Dinosaure
     */
    private int hauteur_saut;

    /**
     * Information si le Dinosaure est en train de sauter
     */
    private boolean isSaute; // est en train de sauter ?

    /**
     * Information si le dinosaure beneficie d'un double saut
     */
    private boolean double_saut;

    /**
     * Constructeur de Dino
     * @param x Position en X
     * @param y Position en Y
     */
    public Dino(double x, double y) {
        super(x,y, new Rectangle(x,y,100,100));
        setPdv(3);
        setPet(Variables.NB_PETS_DEBUT);
        hauteur_saut = 40;
        isSaute = false;
        double_saut = false;
        setImageView(new ImageView(new Image("file:///" + System.getProperty("user.dir") + "/rsrc/media/dino_001.png")));

    }

    /**
     * Sert a infliger un point de vie
     */
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

    public int getHauteurSaut() {
        return this.hauteur_saut;
    }

    public void setHauteurSaut(int valeur) {
        this.hauteur_saut = valeur;
    }

    public boolean isDoubleSaut() {
        return double_saut;
    }

    public void setDoubleSaut(boolean val) {
        //if (val) setHauteurSaut(60);
        //else setHauteurSaut(40);

        this.double_saut = val;
    }

    public boolean isSaute() {
        return isSaute;
    }

    public void setSaute(boolean valeur) {
        this.isSaute = valeur;
    }

}
