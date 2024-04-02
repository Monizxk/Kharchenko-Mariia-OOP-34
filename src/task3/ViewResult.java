package src.task3;

import src.task2.SerializableClass;
import java.io.*;
import java.util.ArrayList;

/**
 * Клас, який реалізує інтерфейс View та надає функціональність для роботи з результатами.
 */
public class ViewResult implements View {
    private static final String FNAME = "items.bin";
    private static final int DEFAULT_NUM = 10;
    private ArrayList<SerializableClass> items = new ArrayList<SerializableClass>();

    /**
     * Конструктор, який ініціалізує список items зі значеннями SerializableClass за замовчуванням.
     */
    public ViewResult() {
        this(DEFAULT_NUM);

        /**
         * Конструктор, який ініціалізує список items з вказаною кількістю об'єктів SerializableClass.
         * @param n кількість об'єктів SerializableClass для створення
         */
    }
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new SerializableClass());
        }
    }

    /**
     * Метод для отримання списку елементів.
     * @return список елементів
     */
    public ArrayList<SerializableClass> getItems() {
        return items;
    }

    /**
     * Метод для обчислення значень згідно з деякою функцією.
     * @param x значення аргументу для обчислення
     * @return обчислене значення
     */
    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);

        /**
         * Метод для ініціалізації значень напруги в елементах списку items з певним кроком.
         * @param stepX крок для ініціалізації напруги
         */
    }
    public void init(double stepX) {
        double voltage = 0.0;
        for(SerializableClass item : items) {
            item.setVoltage(voltage);
            voltage += stepX;
        }
    }

    /**
     * Метод для випадкової ініціалізації значень напруги в елементах списку items.
     */
    public void viewInit() {
        init(Math.random() * 360.0);
    }

    /**
     * Метод для збереження списку items у файл.
     * @throws IOException у випадку помилки вводу/виводу під час збереження
     */
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Метод для відновлення списку items з файлу.
     * @throws Exception у випадку помилки під час відновлення
     */
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<SerializableClass>) is.readObject();
        is.close();
    }

    /**
     * Метод для відображення заголовку результатів.
     */
    public void viewHeader() {
        System.out.println("Results:");
    }

    /**
     * Метод для відображення тіла результатів.
     */
    public void viewBody() {
        for(SerializableClass item : items) {
            System.out.printf(item.toString());
        }
        System.out.println();
    }

    /**
     * Метод для відображення завершення результатів.
     */
    public void viewFooter() {
        System.out.println("End.");
    }

    /**
     * Метод для відображення всієї інформації про результати.
     */
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}