package modele.hitbox;

public class Hitbox {

    private int largeur;
    private int hauteur;

    public Hitbox(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur =hauteur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }


    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
