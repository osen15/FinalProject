package finalProject.controller;

import finalProject.model.Filter;
import finalProject.model.Room;
import finalProject.service.RoomService;
import finalProject.service.UserService;
import finalProject.userType.UserType;
import finalProject.utils.Session;

import java.util.TreeSet;

public class RoomController {
    public Room addRoom(Room room) throws Exception {
        if (Session.getUser() == null)
            throw new Exception("login please");
        if (Session.getUser().getUserType() != UserType.ADMIN)
            throw new Exception(Session.getUser().getUserName() + " no access to the method");
        return RoomService.addRoom(room);
    }

    public TreeSet<Room> findRooms(Filter filter) throws Exception {
        if (Session.getUser() == null)
            throw new Exception("login please");
        return RoomService.findRooms(filter);

    }

    public static void deleteRoom(Room room) throws Exception {
        if (Session.getUser() == null)
            throw new Exception("login please");
        if (Session.getUser().getUserType() != UserType.ADMIN)
            throw new Exception(Session.getUser().getUserName() + " no access to the method");
        RoomService.deleteRoom(room);
    }


}
