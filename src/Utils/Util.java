package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Admin on 02.08.2017.
 */
public class Util {

    public static String loadFileAsString(String path){

        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = new String();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.ready()){
                line = bufferedReader.readLine();
                stringBuilder.append(line+"\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

    public static int parseInt(String number){
         return Integer.parseInt(number);
    }

}
