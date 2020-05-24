package util;

public class MenuUtil {
    public static void selectMenuText(int i) {
        if (i == 1) {
            System.out.println("1. Add language\n" +
                    "2. Add words\n" +
                    "3. Find specific language word\n" +
                    "4. Find word in all language\n" +
                    "5. Show all languages words\n");
        } else if (i == 0) {
            System.out.println("1. Find specific language word\n" +
                    "2. Find word in all language\n");

        } else {
            System.out.println("incorrect choice");
        }
    }


    public static void selectMenuInput(int i) {
        int selectedMenu = InputUtil.typeInteger("Menu seçin: ");
        if (i == 1) {

            if (selectedMenu == 1) {
                Dictonary.addLanguage();
            } else if (selectedMenu == 2) {
                Dictonary.addWords();
            } else if (selectedMenu == 3) {
                Dictonary.findWordAndPrint();
            } else if (selectedMenu == 4) {
                Dictonary.findWordAndPrintOnAllLanguage();
            } else if (selectedMenu == 5) {
                Dictonary.showAllLanguagesWord();
            } else {
                System.out.println("Yanlış seçim");
                selectMenu(i);
            }
        } else if (i == 0) {

            if (selectedMenu == 1) {
                Dictonary.findWordAndPrint();
            } else if (selectedMenu == 2) {
                Dictonary.findWordAndPrintOnAllLanguage();
            } else {
                System.out.println("Yanlış seçim");
                selectMenu(i);
            }
        } else {
            System.out.println("incorrect choice");
        }

    }

    public static void selectMenu(int i) {
        selectMenuText(i);
        selectMenuInput(i);

    }

}
