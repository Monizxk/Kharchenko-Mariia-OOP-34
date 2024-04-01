package src.task2;
/**
 * Обчислюється сила струму через кожен опір при заданій напрузі, після чого
 * результат серіалізується в файл calc_result.ser, а потім десеріалізується
 * з цього файлу для виведення результату обчислень.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.task2.SerializableClass;

public class DeserealizationDemo {
    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {

        // Задання напруги та опорів
        double voltage = 15.0;
        double[] resistances = {10.0, 20.0, 30.0, 40.0, 50.0};

        // Створення об'єкту SerializableClass з заданими параметрами
        SerializableClass calcResult = new SerializableClass(voltage,resistances);
        
        try {
            // Серіалізація об'єкту
            FileOutputStream fileOut = new FileOutputStream("calc_result.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(calcResult);
            out.close();
            fileOut.close();
            System.out.println("Об'єкт серіалізовано та збережено в calc_result.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізація об'єкту
        SerializableClass deserializedResult = null;
        try {
            FileInputStream fileIn = new FileInputStream("calc_result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedResult = (SerializableClass) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Результати обчислення: ");
            System.out.println(deserializedResult);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
