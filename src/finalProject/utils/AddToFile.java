package finalProject.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddToFile {
    public static  <T> T  addToFile(T t, String fileName){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {

            bw.append(t.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }

        return t;
    }

}
