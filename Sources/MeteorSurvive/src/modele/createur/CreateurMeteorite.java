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
 * Classe de création de Météorite, hérite de Createur et implémente Observateur pour être notifier quand il faut creer une Météorite
 */
public class CreateurMeteorite extends Createur implements Observateur {


    /**
     * Boucleur averti pour faire un update
     */
    private Sujet boucleur;

    /**
     * Nombre de tour de boucle necessaire avant de creer une Météorite
     */
    private int more_meteorite;

    /**
     * Variable qui defini la lenteur du jeu, plus elle est élevé, plus le jeu sera long
     */
    private int lenteur_jeu; // = 5 -> lent ; = 0 -> rapide

    /**
     * temoin qui indique si une Météorite doit être creer
     */
    private int temoin;

    /**
     * Constructeur d'un CreateurMétéorite
     * @param m Monde où le créateur vas creer
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
     * Redefinition de la méthode d'update a chaque tour de boucle du Boucleur
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
     * Methode qui defini comment une Météorite doit être créé
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
