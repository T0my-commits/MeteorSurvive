package modele.Colisionneur;

import modele.Objet.Meteorite;
import modele.Objet.Pet;

/**
 * Colisionneur qui gere uniquement les colision des Pets
 */
public class ColisionneurPet extends Colisionneur {

    /**
     * Methode qui verifie si il y a une colision entre le pet et la météorite
     * @param m Meteorite dont on veut savoir si le pets rentre en colision avec
     * @param p Pet dont on veut savoir si la Metéorite rentre en colision avec
     * @return
     */
    public static boolean OnMeteorite(Meteorite m, Pet p) {
        return m.getHitbox().intersects(p.getHitbox().getBoundsInLocal());
    }

}
