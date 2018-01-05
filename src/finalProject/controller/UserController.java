package finalProject.controller;

import finalProject.model.User;
import finalProject.service.UserService;
import finalProject.utils.Session;

public class UserController {


    public static User  registerUser(User user) throws Exception {
        return UserService.registerUser(user);
    }

    public static void login(String userName, String password) throws Exception {
        UserService.login(userName, password);
    }

    public static void logout() {
        Session.ofLine();
    }
}
