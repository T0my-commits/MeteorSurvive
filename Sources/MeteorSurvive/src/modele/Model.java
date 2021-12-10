package modele;

public class Model {

    private DeplaceurBasePerso dep;
    private Colisionneur col;
    private Personnage p;

    public Model(){
        dep = new DeplaceurBasePerso();
        col = new Colisionneur();
        p= new Personnage(0, 150,3);

    }

    public void deplacer(){
        dep.deplacer(p, p.getPosx()+10, p.getPosY());

    }
}
