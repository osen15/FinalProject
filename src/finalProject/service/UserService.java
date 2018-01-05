package finalProject.service;

import finalProject.DAO.UserDAO;
import finalProject.model.User;
import finalProject.utils.Session;

public class UserService {

    public static User registerUser(User user) throws Exception {
        if (checkUser(user.getId()))
            throw new Exception("user: " + user.getId() + "already exists");

        return UserDAO.registerUser(user);
    }


    public static void login(String userName, String password) throws Exception {
        if (userName == null && password == null) {
            throw new NullPointerException("username or password null");
        }

        for (User user : UserDAO.getAll()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                Session.setUserOnLine(user);

                System.out.println(Session.getUser());
                return;
            }
        }
        System.out.println("User with this name does not exist");
    }


    public static User findUserByID(long id) throws Exception {
        for (User user : UserDAO.getAll()) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new Exception("User with this " + id + " not found");
    }


    public static boolean checkUser(long id) throws Exception {
        for (User user : UserDAO.getAll()) {
            if (user.getId() == id) {
                return true;
            }
        }

        return false;
    }



}
