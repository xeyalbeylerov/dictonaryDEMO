/*
 * Copyright (c) 2020.
 * xeyalbeylerov
 */

package file;

import bean.Config;

import java.io.*;

public class FileUtility<T extends Serializable> {
    static String filePath = Config.filePath;

    public static void WriteObjectToFile(Config serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
//            System.out.println("The Object  was succesfully written to a pese.java.file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeObjectToFile(T obj) {

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);

        } catch (IOException ex) {
            System.out.println("Object write Exception");
            ex.printStackTrace();
        }
    }

    public T readObjectFromFile() {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
            return (T) objectIn.readObject();
        } catch(Exception ex){
            System.err.println("You are firstly open this app or file has been deleted");
            return null;
        }
    }

}
