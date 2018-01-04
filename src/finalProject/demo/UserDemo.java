package finalProject.demo;

import finalProject.controller.UserController;
import finalProject.model.User;
import finalProject.userType.UserType;

public class UserDemo {
    public static void main(String[] args) throws Exception {
        User user = new User(1,"Oleg","1111","Ukraine", UserType.ADMIN);
        UserController.registerUser(user);
    }
}
