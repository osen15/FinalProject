package finalProject.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RewritingFile {
    public static <T> void rewritingFile(ArrayList<T> ts, String fileName) {
        ListToStringBuffer.listInStrBuff(ts);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {

            bw.append(ListToStringBuffer.listInStrBuff(ts).toString());

        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }


    }


}
