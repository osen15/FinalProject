package finalProject.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ReadingFile {
    public static List<String> readingFile(String fileName) {
        List<String> lines = new LinkedList<>();

        try

        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (
                IOException e)

        {
            System.err.println("wrong file");
        }

        return lines;
    }


}
