package util;

import bean.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictonary {
    //    public static void addDictonary(){
//        Integer input=InputUtil.typeInteger("Please enter lang index 1(Azerbaijan) 2(English)");
//        if(input==1){
//
//        }else if(input==2){
//
//        }else {
//            System.out.println("Illegal input");
//            addDictonary();
//        }
//    }
//    public static void writeDictonary(){
//        String inputAze=InputUtil.typeString("Please enter Word in Azerbaijan language");
//        String inputEng=InputUtil.typeString("Please enter Word in English language");
//
//        Config.getInstance().getWord().put(inputAze,inputEng);
//
//    }
    //dil elave edir
    public static void addLanguage() {
        String dil = InputUtil.typeString("Yeni dilin adını daxil edin");
        Map<Integer, String> m = new HashMap<>();

        Config.getInstance().getDict().put(dil, m);
    }

    //butun dillere eynianda soz add edir
    public static void addWords() {
        int localCount = Config.count++;
        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
            String word = InputUtil.typeString(entry.getKey() + " dilində daxil edin");
            entry.getValue().put(localCount, word);
        }
    }

    //Butun dillerin sozlerini alt-alta cap edir
    public static void showAllLanguagesWord() {
        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
            Map<Integer, String> hmap = entry.getValue();
            for (int i = 0; i < Config.count; i++) {
                if (entry.getValue().get(i) != null) {
                    System.out.print(i + " " + entry.getKey() + "-");
                    System.out.println(entry.getValue().get(i));
                } else {
                    System.out.println(i + " empty");
                }

            }
        }
    }

    //Butun dillerin sozlerini alt-alta cap edir
//    public static void showAllLanguagesWordAndPrindCorrectWay() {
//        List<List<String>> list2=new ArrayList<>();
//        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
//            List<String> list=new ArrayList<>();
//            Map<Integer, String> hmap = entry.getValue();//hashmap alinir
//
//            for (int i = 0; i < Config.count; i++) {//her lang-in count-u qeder dovr edir
//
//                if (entry.getValue().get(i) != null) {//soz varsa(null deyilse)
//                    String str = null;
//                    str = " " + entry.getKey() + "-";  //indeks cap edilir
//                    str += entry.getValue().get(i) + " ";//soz cap edilir
//
//                    list.add(i,str);
//                } else {
//                    System.out.println(i + " empty");//soz bosdusa emty cap edilir
//                }
//            }
//            list2.add(list);
//
//        }
//        for(List<String> list:list2){
//           for(int i=0;i<list.size();i++) {
//               System.out.print(list.get(i) + " ");
//           }
//        }
//
//
//    }

    //ancaq spesifik dil secib axtarir ve geriye sozun indeksini qaytarir
    private static int findSpecifyLanguageAndReturnIndex() {
        String d = InputUtil.typeString("Axtarilan dil ");

        Map<Integer, String> hmap = null;
        String lang = null;

        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
            lang = entry.getKey();//dil adini menimsedir
            if (lang.equalsIgnoreCase(d)) {//eger bele dil varsa
                hmap = entry.getValue();//hmap-a uygun dilli hashmap menimsedilir
            }
        }

        if (lang == null) System.out.println("dil tapilmadi");
        //bura qeder ancaq dil indeksi alinir

        return findHashMapWordAndRetunIndex(hmap);

    }

    //    hmap qebul edir ve icinde sozu axtarir ve geriye sozun indeksini qaytarir yoxdusa -1 qaytarir
    private static int findHashMapWordAndRetunIndex(Map<Integer, String> hmap) {
        int result = -1;
        String f = InputUtil.typeString("Axtarilan soz");
        for (int i = 0; i < Config.count; i++) {//umumi count qeder dovr edir
            if ((hmap.get(i) != null)) {//soz varsa
                if (hmap.get(i).equalsIgnoreCase(f)) {//soz uygun gelirse
//                        System.out.println("tapildi " + entry.getValue().get(i));

                    result = i;
                }
                System.out.println("Res " + f + " " + hmap.get(i));
            }
        }

        return result;
    }

    //findWords metodunun indeks qaytaran varianti/Butun dilleri yoxlayir, eger soz varsa ilk qabagina cixan sozun indeksini qaytarir
    public static int findAllLanguagesAndReturnIndex() {


        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
            Map<Integer, String> hmap = entry.getValue();//her dile uygun hashmap burada alinir

            return findHashMapWordAndRetunIndex(hmap);


        }
        return -1;
    }

    //soz axtarib capa verir
//    public static void findWords() {
//
//        String f = InputUtil.typeString("Axtarilan soz");
//        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
//            Map<Integer, String> hmap = entry.getValue();//her dile uygun hashmap burada alinir
//
//            for (int i = 0; i < Config.count; i++) {
//                if ((hmap.get(i) != null)) {
//                    if (hmap.get(i).equalsIgnoreCase(f)) {
//                        System.out.println("tapildi " + hmap.get(i));
//                    } else {
////                        System.out.println("tapilmadi");
//                    }
//                } else {
////                    System.out.println("null");
//                }
//            }
//
//        }
//    }

    //indeks alib sozleri duzgun sekilde cap edir
    public static void findWordAndPrint() {
        int numb = findSpecifyLanguageAndReturnIndex();
        System.out.println("WordNumber" + numb);
        System.out.print("result ");
        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
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

    //indeks alib sozleri duzgun sekilde cap edir
    public static void findWordAndPrintOnAllLanguage() {
        int numb = findAllLanguagesAndReturnIndex();
        System.out.println("WordNumber" + numb);
        System.out.print("result ");
        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
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

//    public static int findWordNumber() {
//
//        String f = InputUtil.typeString("Axtarilan soz");
//        for (Map.Entry<String, Map<Integer, String>> entry : Config.getInstance().getDict().entrySet()) {
//            Map<Integer, String> hmap = entry.getValue();
//
//            for (int i = 0; i < Config.count; i++) {
//                if ((entry.getValue().get(i) != null)) {
//                    if (entry.getValue().get(i).equalsIgnoreCase(f)) {
////                        System.out.println("tapildi " + entry.getValue().get(i));
//                        return i;
//
//                    } else {
//
//                    }
//                } else {
//
//                }
//            }
//        }
//        return -1;
//    }
}
