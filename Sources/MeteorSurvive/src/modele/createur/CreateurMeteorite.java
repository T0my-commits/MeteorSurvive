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

import modele.Boucleur.BoucleurMeteorite;
import modele.Colisionneur.Colisionneur;
import modele.Monde;
import modele.Objet.Meteorite;
import modele.Observateur;
import modele.Sujet;
import modele.Variables;

import java.util.Random;

/**
 * Classe de creation de Meteorite, herite de Createur et implemente Observateur pour être notifier quand il faut creer une Meteorite
 */
public class CreateurMeteorite extends Createur implements Observateur {


    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de tour de boucle necessaire avant de creer une Meteorite
     */
    private int more_meteorite;

    /**
     * Variable qui defini la lenteur du jeu, plus elle est eleve, plus le jeu sera long
     */
    private int lenteur_jeu; // = 5 -> lent ; = 0 -> rapide

    /**
     * temoin qui indique si une Meteorite doit être creer
     */
    private int temoin;

    /**
     * Constructeur d'un CreateurMeteorite
     * @param m Monde où le createur vas creer
     * @param boucleM Boucleur qui notifiera pour l'update
     */

    public CreateurMeteorite(Monde m, BoucleurMeteorite boucleurM) {
        super(m);
        boucleur = boucleurM;
        boucleur.attacher(this);
        more_meteorite = Variables.more_meteorite;
        lenteur_jeu = Variables.lenteur_jeu;
        temoin=Variables.temoin;
    }

    /**
     * Redefinition de la methode d'update a chaque tour de boucle du Boucleur
     */
    @Override
    public void update() {
        switch (more_meteorite) {
            case 0: lenteur_jeu = 4; break;
            case 10, 20, 50, 80, 120, 250, 500, 1000, 1500, 2500:
                if (lenteur_jeu > 0)
                    lenteur_jeu -= 1;
                break;
        }


        if (temoin >= lenteur_jeu) {
            this.creer();
            temoin = 0;
        }
        else
            temoin += 1;

        if (lenteur_jeu != 0)
            more_meteorite += 1;
    }


    /**
     *
     * Methode qui defini comment une Meteorite doit être cree
     */
    @Override
    public void creer() {
        Meteorite tmp = new Meteorite(new Random().nextInt(1300) +10 , -150);
        while (Colisionneur.IsColision(tmp, m, tmp.getPosX(), tmp.getPosY())){
            tmp = new Meteorite(new Random().nextInt(1200) +10 , -150);
        }
        m.addMeteorite(tmp);
    }

}
