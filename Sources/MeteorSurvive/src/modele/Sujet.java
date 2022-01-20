package modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui fournit une interface pour attacher et détacher les objets observateurs.
 * Connaît ses observateurs. Un nombre quelconque d'observateurs peut observer un sujet.
 */
public abstract class Sujet {

    /**
     * Liste des Observateurs attaché à ce Sujet
     */
    List<Observateur> observateurs;

    /**
     * Constucteur D'un Sujet
     */
    public Sujet() {
        this.observateurs = new ArrayList<Observateur>();
    }

    /**
     * Attacher un Observateur à ce sujet
     * @param o Observateur à attacher
     */
    public void attacher(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * détacher un Observateur à ce sujet
     * @param o Observateur à détacher
     */
    public void detacher(Observateur o) {
        this.observateurs.remove(o);
    }

    /**
     * Methode qui notifie tous les Observateurs attaché au Sujet
     */
    public void notifier() {
        for(Observateur o : observateurs){
            o.update();
        }
    }

    /**
     * Methode qui détache tous les Observateurs attaché au Sujet
     */
    public void detacherAll(){
        for (Observateur o : observateurs
             ) {
            detacher(o);
        }
    }

}
