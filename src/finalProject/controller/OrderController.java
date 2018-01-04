package finalProject.controller;

import finalProject.service.OrderService;
import finalProject.service.UserService;

public class OrderController {
    public static void bookRoom(long roomId, long userId) throws Exception {
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        OrderService.bookRoom(roomId, userId);

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        OrderService.cancelReservation(roomId, userId);

    }
}
