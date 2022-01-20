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
package modele.Persistance;

import modele.Score.ResultatScore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de chargement des scores grace a la Serialization
 */
public class LoadScoreSerialization implements LoadScore{

    /**
     * methode de chargement des donnees
     * @return liste des scores
     */
    @Override
    public List<ResultatScore> LoadScore() {
        List<ResultatScore> allRes = new ArrayList<>();
        int nblu = 0;
        try {
            FileInputStream fis = new FileInputStream("bin/scores.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

                /*
                while (nblu < 5) { // on charges que les 5 premier scores (les meilleurs)
                    try {
                        allRes.add((ResultatScore) ois.readObject());
                        nblu++;
                    } catch (ClassNotFoundException e) {
                        return allRes;
                    } catch (EOFException e) {
                        return allRes;
                    }
                }*/
            while (true){
                allRes.add((ResultatScore) ois.readObject());
            }


        }
        catch (FileNotFoundException e) {
            System.out.println("Fichier de score inexistant");
        }
        catch (EOFException e){
            return allRes;
        }
        catch (IOException e) {
            e.printStackTrace();
            return allRes;

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return allRes;
    }
}
