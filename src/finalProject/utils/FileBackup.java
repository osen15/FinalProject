package finalProject.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileBackup {

    public static void backup(StringBuffer stringBuffer, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {

            bw.append(stringBuffer.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }

    }
}
