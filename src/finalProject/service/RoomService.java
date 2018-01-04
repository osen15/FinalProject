package finalProject.service;

import finalProject.DAO.RoomDAO;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;
import java.util.TreeSet;

public class RoomService {
    private static final String RoomDB = "C://RoomDB.txt";

    public static Room addRoom(Room room) throws Exception {

        if (checkRoom(room.getId())) {
            throw new Exception("This room :" + room.getId() + " is already exists");
        }

        return RoomDAO.addRoom(room);
    }


    public static void deleteRoom(Room room) throws Exception {
        ArrayList<Room> rooms = RoomDAO.getAll();
        for (Room room1 : RoomDAO.getAll()) {
            if (room1.getId() == room.getId())
                rooms.remove(room1);
        }
        if (RoomDAO.getAll().size() == rooms.size()) {
            throw new Exception("room with this " + room.getId() + " not found");
        }

        RoomDAO.deleteRoom(rooms);

    }

    public static TreeSet<Room> findRooms(Filter filter) throws Exception {
        TreeSet<Room> filteredRooms = new TreeSet<>();
        for (Room room : RoomDAO.getAll())
            if (filter.checkParameters(room))
                filteredRooms.add(room);
        return filteredRooms;
    }

    public static Room findRoomByID(long id, ArrayList<Room> rooms) throws Exception {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }

        throw new Exception("Room with this " + id + " not found");
    }

    public static boolean checkRoom(long id) throws Exception {

        for (Room room : RoomDAO.getAll()) {
            if (room != null && room.getId() == id) {
                return true;
            }
        }

        return false;
    }
}
