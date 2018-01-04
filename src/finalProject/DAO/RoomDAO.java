package finalProject.DAO;

import finalProject.model.Hotel;
import finalProject.model.Room;
import finalProject.utils.AddToFile;
import finalProject.utils.FileValidation;
import finalProject.utils.ReadingFile;
import finalProject.utils.RewritingFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RoomDAO {
    private static int lineCounter = 1;
    private static final String RoomDB = "C://RoomDB.txt";

    public static Room addRoom(Room room) throws Exception {
        FileValidation.fileValidation(RoomDB);
        return AddToFile.addToFile(room, RoomDB);
    }

    public static ArrayList<Room> getAll() throws Exception {
        FileValidation.fileValidation(RoomDB);
        ArrayList<Room> rooms = new ArrayList<>();
        if (ReadingFile.readingFile(RoomDB).isEmpty()) {
            return rooms;
        }
        for (String line : ReadingFile.readingFile(RoomDB)) {
            rooms.add(roomMapper(line));
        }
        return rooms;

    }

    public static void deleteRoom(ArrayList<Room> rooms) {
        RewritingFile.rewritingFile(rooms, RoomDB);
    }

    private static Room roomMapper(String line) throws Exception {
        String[] arrayRoom = line.split("\\, ");
        if (arrayRoom.length != 7) {
            throw new Exception("error in file, line: " + lineCounter);
        }
        lineCounter++;
        return new Room(Long.parseLong(arrayRoom[0]), Integer.parseInt(arrayRoom[1]),
                Double.parseDouble(arrayRoom[2]), Boolean.parseBoolean(arrayRoom[3]),
                Boolean.parseBoolean(arrayRoom[4]), new SimpleDateFormat("dd-MM-yyyy").parse(arrayRoom[5]),
                new Hotel(Long.parseLong(arrayRoom[6])));
    }


}
