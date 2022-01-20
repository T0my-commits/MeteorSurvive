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
package modele.createur;

import modele.Boucleur.Boucleur;
import modele.Boucleur.BoucleurMeteorite;
import modele.Monde;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

/**
 * Classe de creation de Pet, herite de Createur et implemente Observateur pour être notifier quand il faut creer un Pet
 */
public class CreateurPet extends Createur implements Observateur {

    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de meteorites avan de creer un pet
     */
    private int nb_meteorite;

    /**
     * Constructeur d'un CreateurPet
     * @param m Monde où le createur vas creer
     * @param b Boucleur qui notifiera pour l'update
     */
    public CreateurPet(Monde m, Boucleur b) {
        super(m);
        boucleur = b;
        boucleur.attacher(this);
        nb_meteorite = Variables.NB_METEORITES_POUR_UN_PET;
    }

    /**
     * Redefinition de la methode d'update a chaque tour de boucle du Boucleur
     */
    @Override
    public void update() {
        // toutes les NB_METEORITES_POUR_UN_PET meteorites, on cree un pet pour le joueur;
        if (nb_meteorite == 0) {
            this.creer();
            nb_meteorite = Variables.NB_METEORITES_POUR_UN_PET;
        }
        else  nb_meteorite -= 1;
    }


    /**
     *
     * Methode qui defini comment un Pet doit être cree
     */
    @Override
    public void creer() {
        m.getDino().setPet(m.getDino().getPets() + 1);
    }
}
