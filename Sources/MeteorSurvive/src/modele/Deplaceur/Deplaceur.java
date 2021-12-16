package modele.Deplaceur;

import modele.Boucleur.Boucleur;
import modele.Objet.Objet;
import modele.Observateur;

public abstract class Deplaceur extends Observateur {

    private boolean etatObservateur; // utilisé dans les méthodes upadate des classes filles
    private static int velocity;
    Boucleur boucleur; // instancié dans les classes filles

    abstract void update();

}
