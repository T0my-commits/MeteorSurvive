package modele;

import java.io.IOException;

/**
 * Classe abstraite qui definit une interface de mise a jour pour les objets qui doivent être notifies de changements dans un sujet.
 */
public interface Observateur {

    /**
     * Methode qui sera appele lorsque le sujet notifi l'observateur
     */
    void update();

}
