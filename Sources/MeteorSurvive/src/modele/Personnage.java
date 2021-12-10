package modele;

/**
 * Classe qui permet de représenter un joueur dans le jeu (aka le dinosaure)
 */
public class Personnage {
    // un personnage possède certains attributs
    private int posx;
    private int posY;
    private int PtdeVie;

    public Personnage(int posx, int posY, int ptdeVie) {
        this.posx = posx;
        this.posY = posY;
        PtdeVie = ptdeVie;
    }

    public int getPtdeVie() {
        return PtdeVie;
    }

    public void setPtdeVie(int ptdeVie) {
        PtdeVie = ptdeVie;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "posx=" + posx +
                ", posY=" + posY +
                ", PtdeVie=" + PtdeVie +
                '}';
    }
}
