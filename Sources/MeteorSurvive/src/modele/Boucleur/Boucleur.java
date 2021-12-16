package modele.Boucleur;

import modele.Sujet;

public abstract class Boucleur extends Sujet implements Runnable {
    private boolean etatSujet;

    @Override
    public abstract void run();

    public boolean getEtat() {
        return etatSujet;
    }
}
