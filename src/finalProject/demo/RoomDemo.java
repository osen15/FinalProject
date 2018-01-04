package finalProject.demo;

import finalProject.DAO.RoomDAO;
import finalProject.model.Hotel;
import finalProject.model.Room;
import finalProject.service.RoomService;

import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws Exception {
        Room room = new Room(2, 2, 1000, true, true, new Date(), new Hotel(1000));
        RoomService.addRoom(room);
       // RoomService.deleteRoom(room);


    }
}
