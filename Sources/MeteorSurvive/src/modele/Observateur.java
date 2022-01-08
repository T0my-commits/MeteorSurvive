package modele;

/**
 * Classe abstraite qui définit une interface de mise à jour pour les objets qui doivent être notifiés de changements dans un sujet.
 */
public interface Observateur {

    void update();

}