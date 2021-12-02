package modele;

public abstract class Abilities {
    // déclaration des attributs
    protected int xvelocity; // sur l'axe des x
    protected int yvelocity; // sur l'axe des y
    protected int damage;

    /*
       Getters et Setters
       Les classes filles de cette classe vont hériter automatiquement de ces getters
       et setters, inutile donc de les redéfinir par la suite !
     */
    public int getXvelocity() {
        return xvelocity;
    }

    public void setXvelocity(int xvelocity) {
        this.xvelocity = xvelocity;
    }

    public int getYvelocity() {
        return yvelocity;
    }

    public void setYvelocity(int yvelocity) {
        this.yvelocity = yvelocity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
