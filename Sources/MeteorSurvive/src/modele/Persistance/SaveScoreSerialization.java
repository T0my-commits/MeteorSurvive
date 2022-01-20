package modele.Persistance;

import javafx.collections.transformation.SortedList;
import modele.Score.ResultatScore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * Classe de sauvegarde des scores grace a la Serialization
 */
public class SaveScoreSerialization implements SaveScore {


    /**
     * methode de sauvegarde des donnees
     *
     */

    /**
     * methode de sauvegarde des donnees
     * @param allscore tous les scores triee
     */
    @Override
    public void SaveScore(SortedList<ResultatScore> allscore) throws Exception {

        try (FileOutputStream fos = new FileOutputStream("bin/scores.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            /*
            if(allscore.size()<=5){/// si il y a moin de 5 scores
                for (ResultatScore res : allscore
                ) {
                    System.out.println(res);
                    oos.writeObject(res);
                }
            }

            else {
                for(int i =1; i<=5;i++){ // on sauvegarde que les 5 meilleurs scores
                    System.out.println(allscore.get(allscore.size()-i));
                    oos.writeObject(allscore.get(allscore.size()-i));
                }
            }*/
            for (ResultatScore res : allscore
            ) {
                oos.writeObject(res);
            }

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
