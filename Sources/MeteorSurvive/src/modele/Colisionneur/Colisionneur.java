package modele.Colisionneur;

import modele.Objet.Personnage;

public class Colisionneur {

    public boolean isCollision(Personnage p1, Personnage p2){
        if(p1.getPosx() == p2.getPosx() && p1.getPosY() == p2.getPosY()){
            System.out.println("Attention colision entre les personnages");
            return true;
        }
        return false;

    }
}
