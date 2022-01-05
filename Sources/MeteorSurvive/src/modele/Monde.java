package modele;

import modele.Objet.Dino;
import modele.Objet.Objet;

import java.util.*;

/**
 * Le role du maitre du jeu est d'autoriser certaines les actions des objets en cours de partie.
 *
 * Il possède :
 *  - une instance de chaque objets dans le jeu ;
 *  - la capacité d'appeler chaque éléments du jeu et les faire travailler ensemble;
 */
public class Monde {
    private List<Objet> allObject;
    private Dino dino;

    public Monde() {
        dino = new Dino(0,1,100);
        allObject = new ArrayList<>();
    }

    public void addObjet(Objet o){
        allObject.add(o);
    }

    public List<Objet> getObjet(){
        return allObject;
    }

    public Dino getDino() { return dino; }

}
