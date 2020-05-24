package util;

import java.util.Scanner;

public class InputUtil {
    static Scanner scan = new Scanner(System.in);

    public static String typeString(String msg) {
        System.out.println(msg);
        return scan.next();
    }

    public static Integer typeInteger(String msg) {
        System.out.println(msg);
        int i=-1;
        try {
            i = scan.nextInt();
        } catch (Exception ex) {
            System.out.println("Please type correct number");
        }
        return i;
    }
}
