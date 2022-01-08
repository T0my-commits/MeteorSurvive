package modele.createur;

import modele.Monde;

public abstract class Createur {

     Monde m;

     public Createur(Monde m){
        this.m = m;
     }

    public abstract void creer(Monde m);

}
