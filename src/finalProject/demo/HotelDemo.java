package finalProject.demo;

import finalProject.controller.HotelController;
import finalProject.model.Hotel;
import finalProject.utils.GenerateID;

public class HotelDemo {
    public static void main(String[] args) throws Exception {
        Hotel hotel1 = new Hotel(3000, "Eney", "Ukraine", "Lviv", "I. Franko st.");
        Hotel hotel2 = new Hotel(2, "Panorama", "Ukraine", "Lviv", "I. Franko st.");
        Hotel hotel3 = new Hotel(GenerateID.generateID(), "Leopolis", "Ukraine", "Lviv", "I. Franko st.");
        HotelController.addHotel(hotel1);

       // System.out.println(HotelController.findHoteByName("Eney"));
       // System.out.println(HotelController.findHotelByCity("Uki"));
       // HotelController.deleteHotel(hotel1);

    }
}
