package modele.Persistance;

import javafx.collections.transformation.SortedList;
import modele.Score.ResultatScore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveScoreSerialization implements SaveScore {


    @Override
    public void SaveScore(SortedList<ResultatScore> allscore) throws Exception {

        try (FileOutputStream fos = new FileOutputStream("bin/scores.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            for (ResultatScore res : allscore
                 ) {
                System.out.println(res);
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
