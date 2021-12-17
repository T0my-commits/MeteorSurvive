package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui fournit une interface pour attacher et détacher les objets observateurs.
 * Connaît ses observateurs. Un nombre quelconque d'observateurs peut observer un sujet.
 */
public abstract class Sujet {

    List<Observateur> observateurs;

    public Sujet() {
        this.observateurs = new ArrayList<Observateur>();
    }

    public void attacher(Observateur o) {
        this.observateurs.add(o);
    }

    public void detacher(Observateur o) {
        this.observateurs.remove(o);
    }

    public void notifier(){
        for(Observateur o : observateurs){
            o.update();
        }
    }

}
