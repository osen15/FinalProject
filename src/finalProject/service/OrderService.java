package finalProject.service;

import finalProject.DAO.OrderDAO;
import finalProject.DAO.RoomDAO;
import finalProject.model.Order;
import finalProject.model.Room;
import finalProject.model.User;
import finalProject.utils.FileBackup;
import finalProject.utils.GenerateID;
import finalProject.utils.ListToStringBuffer;
import finalProject.utils.RewritingFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {
    private static final String RoomDB = "C://RoomDB.txt";
    private static final String OrderDB = "C://OrderDB.txt";

    public static void bookRoom(long roomId, long userId) throws Exception {
        ArrayList<Room> rooms = RoomDAO.getAll();

        Room room = RoomService.findRoomByID(roomId, rooms);
        User user = UserService.findUserByID(userId);

        Order order = new Order(GenerateID.generateID(), user, room,
                room.getDateAvailableFrom(), new Date(), room.getPrice());
        order.setMoneyPaid((amountOfDays(order.getDateFrom(), order.getDateTo()) * room.getPrice()));

        OrderDAO.addOrder(order);

        room.setDateAvailableFrom(order.getDateTo());
        RewritingFile.rewritingFile(rooms, RoomDB);

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = OrderDAO.getAll();
        ArrayList<Room> rooms = RoomDAO.getAll();
        StringBuffer stbOrders = ListToStringBuffer.listInStrBuff(orders);
        StringBuffer stbRooms = ListToStringBuffer.listInStrBuff(rooms);

        try {
            for (Order order : orders) {

                if (order.getUser().getId() == userId && order.getRoom().getId() == roomId) {
                    RoomService.findRoomByID(roomId, rooms).setDateAvailableFrom(new Date());
                    orders.remove(order);
                    RewritingFile.rewritingFile(orders, OrderDB);
                    break;
                }

            }
        } catch (IOException e) {
            FileBackup.backup(stbOrders, OrderDB);
            FileBackup.backup(stbRooms, RoomDB);
            System.err.println("You can not cancel your reservation. Please try again later");

        }


    }

    public static Order findOrderByID(long id) throws Exception {
        for (Order order : OrderDAO.getAll()) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new Exception("Order: " + id + "already exists");

    }

    private static long amountOfDays(Date dateFrom, Date dateTo) {
        long dayInMillsec = 24 * 60 * 60 * 1000;
        return (dateTo.getTime() - dateFrom.getTime()) / dayInMillsec;

    }
}
