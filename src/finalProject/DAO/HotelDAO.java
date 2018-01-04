package finalProject.DAO;

import finalProject.model.Hotel;
import finalProject.utils.AddToFile;
import finalProject.utils.FileValidation;
import finalProject.utils.ReadingFile;
import finalProject.utils.RewritingFile;

import java.util.ArrayList;

public class HotelDAO {
    private static int lineCounter = 1;
    private static final String HotelDB = "C://HotelDB.txt";

    public static Hotel addHotel(Hotel hotel) throws Exception {
        FileValidation.fileValidation(HotelDB);
        return AddToFile.addToFile(hotel, HotelDB);
    }

    public static ArrayList<Hotel> getAll() throws Exception {
        FileValidation.fileValidation(HotelDB);
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (String line : ReadingFile.readingFile(HotelDB)) {
            hotels.add(hotelMapper(line));
        }
        return hotels;
    }

    public static void deleteHotel(ArrayList<Hotel> hotels) {
        RewritingFile.rewritingFile(hotels, HotelDB);

    }

    public static Hotel hotelMapper(String line) throws Exception {
        String[] arrayHotel = line.split("\\, ");
        if (arrayHotel.length != 5) {
            throw new Exception("error in file: line " + lineCounter);

        }
        lineCounter++;
        return new Hotel(Long.parseLong(arrayHotel[0]), arrayHotel[1], arrayHotel[2], arrayHotel[3], arrayHotel[4]);
    }

}
