package modele;

import java.io.IOException;

/**
 * Classe abstraite qui définit une interface de mise à jour pour les objets qui doivent être notifiés de changements dans un sujet.
 */
public interface Observateur {

    /**
     * Methode qui sera appelé lorsque le sujet notifi l'observateur
     */
    void update();

}
