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
