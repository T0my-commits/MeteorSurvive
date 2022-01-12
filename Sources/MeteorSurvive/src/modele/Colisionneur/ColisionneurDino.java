package modele.Colisionneur;

import modele.Monde;
import modele.Objet.Entite;

public class ColisionneurDino extends Colisionneur{

    public static boolean OnGround(Monde m) {
        return OnGround(m, m.getDino());
    }

}
