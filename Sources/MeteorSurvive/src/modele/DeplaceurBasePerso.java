package modele;

public class DeplaceurBasePerso extends Deplaceur {

    private static int velocity = 10;



    public void deplacer(Personnage pers, int x, int y) {
        pers.setPosx(x);
        pers.setPosY(y);
    }
}
