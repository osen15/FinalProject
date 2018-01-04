package finalProject.DAO;

import finalProject.model.User;
import finalProject.userType.UserType;
import finalProject.utils.AddToFile;
import finalProject.utils.FileValidation;
import finalProject.utils.ReadingFile;

import java.util.ArrayList;

public class UserDAO {
    private static int lineCounter = 1;
    private static String UserDB = "C://UserDB.txt";

    public static User registerUser(User user) throws Exception {
        FileValidation.fileValidation(UserDB);
        return AddToFile.addToFile(user, UserDB);
    }


    public static ArrayList<User> getAll() throws Exception {
        FileValidation.fileValidation(UserDB);
        ArrayList<User> users = new ArrayList<>();

        for (String line : ReadingFile.readingFile(UserDB)) {
            users.add(userMapper(line));
        }

        return users;
    }

    public static User userMapper(String line) throws Exception {
        String[] arrayUser = line.split("\\, ");
        if (arrayUser.length != 5) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new User(Long.parseLong(arrayUser[0]), arrayUser[1], arrayUser[2], arrayUser[3], UserType.valueOf(arrayUser[4]));
    }
}
