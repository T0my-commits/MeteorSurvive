package modele.Colisionneur;

import modele.Objet.Objet;

public class Colisionneur {

    public boolean isCollision(Objet o1, Objet o2){
        if(o1.getPosX() == o2.getPosX() && o1.getPosY() == o2.getPosY()){
            System.out.println("Attention colision entre les objets");
            return true;
        }
        return false;

    }
}
