package modele;

/**
 * La classe Objet défini un template pour tout les autres objets;
 */
public abstract class Objet {
    // déclaration des attributs
    private String url_visuel; // l'url vers l'aspect de l'objet;
    protected float xvelocity; // sur l'axe des x
    protected float yvelocity; // sur l'axe des y
    protected int damage;

    /*
       Getters et Setters
       Les classes filles de cette classe vont hériter automatiquement de ces getters
       et setters, inutile donc de les redéfinir par la suite !
     */
    public float getXvelocity() {
        return xvelocity;
    }

    public void setXvelocity(int xvelocity) {
        this.xvelocity = xvelocity;
    }

    public float getYvelocity() {
        return yvelocity;
    }

    public void setYvelocity(int yvelocity) {
        this.yvelocity = yvelocity;
    }
}
