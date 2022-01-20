package modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui fournit une interface pour attacher et detacher les objets observateurs.
 * Connaît ses observateurs. Un nombre quelconque d'observateurs peut observer un sujet.
 */
public abstract class Sujet {

    /**
     * Liste des Observateurs attache a ce Sujet
     */
    List<Observateur> observateurs;

    /**
     * Constucteur D'un Sujet
     */
    public Sujet() {
        this.observateurs = new ArrayList<Observateur>();
    }

    /**
     * Attacher un Observateur a ce sujet
     * @param o Observateur a attacher
     */
    public void attacher(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * detacher un Observateur a ce sujet
     * @param o Observateur a detacher
     */
    public void detacher(Observateur o) {
        this.observateurs.remove(o);
    }

    /**
     * Methode qui notifie tous les Observateurs attache au Sujet
     */
    public void notifier() {
        for(Observateur o : observateurs){
            o.update();
        }
    }

    /**
     * Methode qui detache tous les Observateurs attache au Sujet
     */
    public void detacherAll(){
        for (Observateur o : observateurs
             ) {
            detacher(o);
        }
    }

}
