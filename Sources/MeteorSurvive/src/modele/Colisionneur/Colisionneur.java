package modele.Colisionneur;

import modele.Objet.Entite;

public class Colisionneur {

    public boolean isCollision(Entite o1, Entite o2){
        if(o1.getPosX() == o2.getPosX() && o1.getPosY() == o2.getPosY()){
            System.out.println("Attention collision entre les objets");
            return true;
        }
        return false;
    }
}
