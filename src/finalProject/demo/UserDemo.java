package finalProject.demo;

import finalProject.DAO.UserDAO;
import finalProject.controller.UserController;
import finalProject.model.User;
import finalProject.service.UserService;
import finalProject.userType.UserType;
import finalProject.utils.Session;

import java.util.ArrayList;

public class UserDemo {
    public static void main(String[] args) throws Exception {
        User user = new User(2,"Max","2222","Ukraine", UserType.USER);
       // UserController.registerUser(user);
       // System.out.println(UserDAO.getAll());

      // UserController.login("Oleg", "1111");



       // UserService.isOnline(user);

       // UserService.logout();
       // System.out.println(UserService.userOnline);
        ArrayList<User> users = new ArrayList<>(1);
       // users.add(user);
        System.out.println(users);
    }
}
