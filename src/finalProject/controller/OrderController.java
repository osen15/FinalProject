package finalProject.controller;

import finalProject.service.OrderService;
import finalProject.service.UserService;
import finalProject.utils.Session;

public class OrderController {
    public static void bookRoom(long roomId, long userId) throws Exception {
        if (Session.getUser() == null)
            throw new Exception("login please");
        OrderService.bookRoom(roomId, userId);

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        if (Session.getUser() == null)
            throw new Exception("login please");
        OrderService.cancelReservation(roomId, userId);

    }
}
