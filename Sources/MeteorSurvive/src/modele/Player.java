package modele;

/**
 * Classe qui permet de représenter un joueur dans le jeu (aka le dinosaure)
 */
public class Player {
    // un joueur possède certains attributs
    private final int velocity = 10;

    /**
     * Constructeur de joueur
     */
    public Player() {
    }

    /**
     * Getter de la vitesse du joueur
     * @return la vitesse du joueur
     */
    public int getVelocity() {
        return velocity;
    }

}
