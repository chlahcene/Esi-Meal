package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveFile {

    static public String nomFile = "file.data" ;
    static public void writeObjectToFile(Object obj){

        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream(nomFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public Object readObjectFromFile(){
        Object obj;
        try {
            // read object from file
            FileInputStream fos = new FileInputStream(nomFile);
            ObjectInputStream ois = new ObjectInputStream(fos);
             obj = ois.readObject();
            ois.close();
            return obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
