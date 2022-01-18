package modele.Persistance;

import modele.Score.ResultatScore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadScoreSerialization implements LoadScore{
    @Override
    public List<ResultatScore> LoadScore() {
        List<ResultatScore> allRes = new ArrayList<>();
        int nblu = 0;
        try {
            FileInputStream fis = new FileInputStream("bin/scores.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            {
                while (nblu < 5) {
                    try {
                        allRes.add((ResultatScore) ois.readObject());
                        nblu++;
                    } catch (ClassNotFoundException e) {
                        return allRes;
                    } catch (EOFException e) {
                        return allRes;
                    }
                }
            }
            return allRes;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            return allRes;

        }
        return allRes;
    }
}
