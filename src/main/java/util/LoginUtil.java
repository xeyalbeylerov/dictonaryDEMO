package util;

import main.Main;

public class LoginUtil {
    public static int checkAdminOrUser(String person) {
        if (person.trim().equalsIgnoreCase("admin")) {
            return 1;
        } else if (person.trim().equalsIgnoreCase("user")) {
            return 0;
        } else {
            System.err.println("Illegal format");
            Main.startApp();
            return -1;
        }
    }
}
