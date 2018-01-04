package finalProject.utils;

import java.io.File;
import java.io.FileNotFoundException;

public class FileValidation {
    public static void fileValidation(String FileName) throws Exception { // валідація
        if (FileName == null) {
            throw new Exception("Path can't be null");
        }
        File fileFrom = new File(FileName);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + FileName + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File: " + FileName + "doesn't have permissions to be read");
        }

    }
}
