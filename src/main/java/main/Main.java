package main;

import bean.Config;
import util.InputUtil;
import util.LoginUtil;
import util.MenuUtil;

import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Config c = Context.getFileUtility().readObjectFromFile();
        Config.setConfig(c);
        startApp();
    }

    public static void startApp() {
        String person = InputUtil.typeString("Please type:admin or user?");
        int personIndex = LoginUtil.checkAdminOrUser(person);
        if (personIndex == 1 || personIndex == 0) {
            while (true) {
                MenuUtil.selectMenu(personIndex);

            }

        } else {
            System.err.println("User not found");

            startApp();
        }
    }
}
