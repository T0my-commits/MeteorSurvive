package modele.Deplaceur;

import modele.Colisionneur.Colisionneur;
import modele.Colisionneur.ColisionneurDino;
import modele.Colisionneur.ColisionneurItem;
import modele.Colisionneur.ColisionneurPet;
import modele.Monde;
import modele.Objet.Item;
import modele.Objet.ItemRechargePet;
import modele.Objet.Meteorite;
import modele.Sujet;

import java.util.List;

public class DeplaceurItem extends Deplaceur {

    private final int gravite;

    public DeplaceurItem(Sujet s, Monde m) {
        setBoucleur(s);
        s.attacher(this);
        setMonde(m);
        gravite = 5;
    }

    @Override
    public void update() {
        List<Item> p = getMonde().getItems();
        for(Item i : p) {
            if (!ColisionneurItem.OnGround(getMonde(), i))
                i.updateY(gravite);
        }
    }
}

