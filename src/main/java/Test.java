import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    static Map<String, Map<Integer, String>> dict = new HashMap<>();
    static Scanner scan = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {

        while (true) {
            addLang();
            addWord();
//            showWords();
            findSpecifyWords();
            System.out.println("count = " + count);
        }
    }

    public static void addLang() {
        System.out.println("Yeni dili daxil edin");
        String dil = scan.nextLine();

        Map<Integer, String> m2 = new HashMap<>();
//        Word w=new Word("Azerbaijan lang",1);

        dict.put(dil, m2);
    }

    public static void addWord() {
        int localCount = count++;
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + " dilində daxil edin");
            String word = scan.nextLine();
            entry.getValue().put(localCount, word);
        }
//        dict.get("Azerbaijan lang").put(0, "alma");
    }

    public static void showWords() {
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {
            Map<Integer, String> hmap = entry.getValue();
            for (int i = 0; i < count; i++) {
                if (entry.getValue().get(i) != null) {
                    System.out.print(i + " " + entry.getKey() + "-");
                    System.out.println(entry.getValue().get(i));
                } else {
                    System.out.println(i + " empty");
                }

            }
        }

    }

    public static int findSpecifyLanguageWord() {
        System.out.println("Axtarilan dil ");
        String d = scan.nextLine();
        Map<Integer, String> hmap = null;
        String lang = null;
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {

            lang = entry.getKey();

            if (lang.equalsIgnoreCase(d)) {

                hmap = entry.getValue();
            }
        }
        if (lang == null) System.out.println("dil tapilmadi");
        //bura qeder ancaq dil indeksi alinir


        System.out.println("Axtarilan soz");
        String f = scan.nextLine();


        for (int i = 0; i < count; i++) {
            if ((hmap.get(i) != null)) {
                if (hmap.get(i).equalsIgnoreCase(f)) {
//                        System.out.println("tapildi " + entry.getValue().get(i));
                    return i;

                } else {

                }
            } else {

            }

        }
        return -1;
    }

    public static void findWord() {
        System.out.println("Axtarilan soz");
        String f = scan.nextLine();
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {
            Map<Integer, String> hmap = entry.getValue();

            for (int i = 0; i < count; i++) {
                if ((hmap.get(i) != null)) {
                    if (hmap.get(i).equalsIgnoreCase(f)) {
                        System.out.println("tapildi " + hmap.get(i));
                    } else {
                        System.out.println("tapilmadi");
                    }
                } else {
                    System.out.println("null");

                }
            }

        }
    }

    public static void findSpecifyWords() {
//        int numb = findWordNumber();
        int numb = findSpecifyLanguageWord();
        System.out.println("WordNumber" + numb);
        System.out.print("result ");
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {
            Map<Integer, String> hmap = entry.getValue();

//            for (int i = 0; i < count; i++) {
            if (numb != -1) {
//

                System.out.print(" " + entry.getKey() + ": ");


                if (hmap.get(numb) != null) {
                    System.out.print(hmap.get(numb) + " ");
                } else {
                    System.out.print("empty" + " ");
                }

//
            } else {
                System.out.println("Index " + numb + " tapilmadi");

            }
//            }
        }
        System.out.println("");
    }

    public static int findWordNumber() {
        System.out.println("Axtarilan soz");
        String f = scan.nextLine();
        for (Map.Entry<String, Map<Integer, String>> entry : dict.entrySet()) {
            Map<Integer, String> hmap = entry.getValue();

            for (int i = 0; i < count; i++) {
                if ((entry.getValue().get(i) != null)) {
                    if (entry.getValue().get(i).equalsIgnoreCase(f)) {
//                        System.out.println("tapildi " + entry.getValue().get(i));
                        return i;

                    } else {

                    }
                } else {

                }
            }
        }
        return -1;
    }


}
