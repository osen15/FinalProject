package finalProject.utils;

import java.util.Random;

public class GenerateID {
    public static long generateID() {
        return  new Random().nextLong();
    }
}
