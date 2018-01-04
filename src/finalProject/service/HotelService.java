package finalProject.service;

import finalProject.DAO.HotelDAO;
import finalProject.DAO.RoomDAO;
import finalProject.model.Hotel;
import finalProject.model.Room;
import finalProject.utils.RewritingFile;

import java.io.IOException;
import java.util.ArrayList;

public class HotelService {
    private static final String HotelDB = "C://HotelDB.txt";
    private static final String RoomDB = "C://RoomDB.txt";

    public static Hotel addHotel(Hotel hotel) throws Exception {
        if (hotel == null) {
            throw new Exception("hotel is null");
        }
        if (checkHotel(hotel.getId())) {
            throw new Exception("hotel " + hotel.getId() + " already exists");
        }
        return HotelDAO.addHotel(hotel);

    }

    public static ArrayList<Hotel> findHoteByName(String name) throws Exception {
        if (name == null) {
            throw new NullPointerException("name is null ");
        }
        ArrayList<Hotel> hotelsByName = HotelDAO.getAll();

        for (Hotel hotel : hotelsByName) {
            if (!hotel.getHotelName().equals(name))
                hotelsByName.remove(hotel);
        }
        if (hotelsByName.size() == 0) {
            throw new Exception("hotel with this name was not found");
        }
        return hotelsByName;
    }


    public static ArrayList<Hotel> findHoteByCity(String city) throws Exception {
        if (city == null) {
            throw new NullPointerException("name is null ");
        }
        ArrayList<Hotel> hotels = HotelDAO.getAll();
        ArrayList<Hotel> hotelsByName = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equals(city))
                hotelsByName.add(hotel);
        }
        if (hotelsByName.isEmpty()) {
            throw new Exception("Hotels in " + city + " not found.");
        }
        return hotelsByName;
    }

    public static void deleteHotel(Hotel hotel) throws Exception {
        deleteAllRoomsInHotel(hotel);
        ArrayList<Hotel> hotels = HotelDAO.getAll();
        hotels.remove(findHotelByID(hotel.getId()));
        if (HotelDAO.getAll().size() == hotels.size())
            throw new Exception("hotel with this" + hotel.getId() + " not found");

        HotelDAO.deleteHotel(hotels);

    }

    public static void deleteAllRoomsInHotel(Hotel hotel) throws Exception {
        ArrayList<Room> rooms = RoomDAO.getAll();
        for (Room room : RoomDAO.getAll()) {
            if (room.getHotel().getId() == hotel.getId())
                rooms.remove(room);
        }

        RewritingFile.rewritingFile(rooms, RoomDB);


    }

    public static Hotel findHotelByID(long id) throws Exception {
        for (Hotel hotel : HotelDAO.getAll()) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }

        throw new Exception("Hotel with this " + id + " not found");
    }

    public static boolean checkHotel(long id) throws Exception {
        for (Hotel hotel : HotelDAO.getAll()) {
            if (hotel.getId() == id) {
                return true;
            }
        }
        return false;

    }
}
