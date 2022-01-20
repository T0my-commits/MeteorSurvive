/*
                            ___......__             _
                        _.-'           ~-_       _.=a~~-_
--=====-.-.-_----------~   .--.       _   -.__.-~ ( ___===>
              '''--...__  (    \ \\\ { )       _.-~
                        =_ ~_  \\-~~~//~~~~-=-~
                         |-=-~_ \\   \\
                         |_/   =. )   ~}
                         |}      ||
                        //       ||
                      _//        {{
                   '='~'          \\_
                                   ~~'

 ___ ___    ___ ______    ___   ___   ____        _____ __ __  ____  __ __  ____  __ __    ___
|   |   |  /  _]      |  /  _] /   \ |    \      / ___/|  |  ||    \|  |  ||    ||  |  |  /  _]
| _   _ | /  [_|      | /  [_ |     ||  D  )    (   \_ |  |  ||  D  )  |  | |  | |  |  | /  [_
|  \_/  ||    _]_|  |_||    _]|  O  ||    /      \__  ||  |  ||    /|  |  | |  | |  |  ||    _]
|   |   ||   [_  |  |  |   [_ |     ||    \      /  \ ||  :  ||    \|  :  | |  | |  :  ||   [_
|   |   ||     | |  |  |     ||     ||  .  \     \    ||     ||  .  \\   /  |  |  \   / |     |
|___|___||_____| |__|  |_____| \___/ |__|\_|      \___| \__,_||__|\_| \_/  |____|  \_/  |_____|

By Deviennne Thomas & Bourdiaux Pierre
Projet de 2nd Année, DUT Informatique Aubiere
*/
package modele.Score;

import javafx.beans.property.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Classe qui gerer un score deja fait, implemente Serializable pour la persistance
 */
public class ResultatScore implements Serializable {

    //private long score;
    private SimpleLongProperty score;
    private SimpleStringProperty nomJoueur;

    //private String nomJoueur;


    static final long serialVersionUID = 8216180604790104263L;
    /**
     * Constructeur d'un ResultatScore
     * @param score
     * @param nomJoueur
     */
    public ResultatScore(long score, String nomJoueur) {
        this.score=new SimpleLongProperty();
        this.score.set(score);
        this.nomJoueur=new SimpleStringProperty();
        this.nomJoueur.set(nomJoueur);
    }

    /*
    public ResultatScore(String score, String nomJoueur) {
        this.score=new SimpleStringProperty();
        this.score.set(String.valueOf(score));
        this.nomJoueur=new SimpleStringProperty();
        this.nomJoueur.set(nomJoueur);
    }*/



    public Long getScore() {
        return score.get();
    }

    public void setScore(long newscore) {
        this.score.set(newscore);
    }

    /*
    public void setScore(String newscore) {
        this.score.set(newscore);
    }*/

    public String getNomJoueur() {
        return nomJoueur.get();
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur.set(nomJoueur);
    }

    /*

    public Long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }*/

    @Override
    public String toString() {
        return "ResultatScore{" +
                "score=" + score +
                ", nomJoueur='" + nomJoueur + '\'' +
                '}';
    }

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {

        score = new SimpleLongProperty();
        nomJoueur = new SimpleStringProperty();
        String tmpScore = aInputStream.readUTF();
        String tmpNom= aInputStream.readUTF();

        if(tmpScore == null)this.score.set(0);
        else this.score.set(Long.valueOf(tmpScore));

        if(tmpNom == null)this.nomJoueur.set("T-rex");
        this.nomJoueur.set(tmpNom);

    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        if(score.get() == 0)aOutputStream.writeUTF(String.valueOf(0));
        else aOutputStream.writeUTF(String.valueOf(score.get()));
        if(nomJoueur.get() == null)aOutputStream.writeUTF("T-Rex");
        else aOutputStream.writeUTF(nomJoueur.get());

    }

}
