package finalProject.utils;

import finalProject.model.User;

public class Session {
    private static User user;


    public Session() {
    }

    public static void ofLine() {
        user = null;
    }

    public static User getUser() {
        return user;
    }



    public static void setUserOnLine(User user) {

       Session.user = user;
    }
}



