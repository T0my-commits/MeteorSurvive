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
            if(allscore.size()<=5){
                for (ResultatScore res : allscore
                ) {
                    System.out.println(res);
                    oos.writeObject(res);
                }
            }
            else {
                for(int i =1; i<=5;i++){
                    System.out.println(allscore.get(allscore.size()-i));
                    oos.writeObject(allscore.get(allscore.size()-i));
                }
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
