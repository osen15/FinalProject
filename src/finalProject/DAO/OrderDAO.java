package finalProject.DAO;

import finalProject.model.Order;
import finalProject.model.Room;
import finalProject.model.User;
import finalProject.utils.AddToFile;
import finalProject.utils.FileValidation;
import finalProject.utils.ReadingFile;
import finalProject.utils.RewritingFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderDAO {
    private static int lineCounter = 1;
    private static final String OrderDB = "C://OrderDB.txt";

    public static Order addOrder(Order order) throws Exception {
        FileValidation.fileValidation(OrderDB);
        return AddToFile.addToFile(order, OrderDB);
    }


    public static ArrayList<Order> getAll() throws Exception {
        FileValidation.fileValidation(OrderDB);
        ArrayList<Order> orders = new ArrayList<>();

        for (String line : ReadingFile.readingFile(OrderDB)) {
            orders.add(orderMapper(line));
        }
        return orders;


    }

    public static void deleteOrder(ArrayList<Order> orders) {
        RewritingFile.rewritingFile(orders, OrderDB);
    }


    public static Order orderMapper(String line) throws Exception {
        String[] arrayOrder = line.split("\\, ");
        if (arrayOrder.length != 6) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new Order(Long.parseLong(arrayOrder[0]), new User(Long.parseLong(arrayOrder[1])),
                new Room(Long.parseLong(arrayOrder[2])), new SimpleDateFormat("dd-MM-yyyy").parse(arrayOrder[3]),
                new SimpleDateFormat("dd-MM-yyyy").parse(arrayOrder[4]), Double.parseDouble(arrayOrder[5]));

    }

}
