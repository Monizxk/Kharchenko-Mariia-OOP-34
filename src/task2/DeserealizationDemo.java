package src.task2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.task2.SerializableClass;

public class DeserealizationDemo {
    public static void main(String[] args) {

        SerializableClass calcResult = new SerializableClass(10, 20, 200);
        
        try {
            FileOutputStream fileOut = new FileOutputStream("calc_result.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(calcResult);
            out.close();
            fileOut.close();
            System.out.println("Об'єкт серіалізовано та збережено в calc_result.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        SerializableClass deserializedResult = null;
        try {
            FileInputStream fileIn = new FileInputStream("calc_result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedResult = (SerializableClass) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        if (deserializedResult != null) {
            System.out.println("Параметр 1: " + deserializedResult.getParameter1());
            System.out.println("Параметр 2: " + deserializedResult.getParameter2());
            System.out.println("Результат: " + deserializedResult.getResult());
        }
    }
}
