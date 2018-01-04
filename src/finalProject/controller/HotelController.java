package finalProject.controller;

import finalProject.model.Hotel;
import finalProject.service.HotelService;
import finalProject.service.UserService;
import finalProject.userType.UserType;

import java.util.ArrayList;

public class HotelController {
    public static Hotel addHotel(Hotel hotel) throws Exception {
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        if (UserService.getUserOnline().getUserType() != UserType.ADMIN)
            throw new Exception(UserService.getUserOnline().getUserName() + " no access to the method");

        return HotelService.addHotel(hotel);

    }

    public static ArrayList<Hotel> findHoteByName(String name) throws Exception {
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        return HotelService.findHoteByName(name);
    }

    public static ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        return HotelService.findHoteByCity(city);
    }

    public static void deleteHotel(Hotel hotel)throws Exception{
        if (UserService.getUserOnline() == null)
            throw new Exception("login please");
        if (UserService.getUserOnline().getUserType() != UserType.ADMIN)
            throw new Exception(UserService.getUserOnline().getUserName() + " no access to the method");
        HotelService.deleteHotel(hotel);
    }
}
