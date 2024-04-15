package src.task3;

import src.task2.SerializableClass;
import src.task4.ViewableTable;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Клас, який реалізує інтерфейс View та надає функціональність для роботи з результатами.
 */
public class ViewResult extends ViewableTable implements View {

    /** Ім'я файлу для збереження/відновлення результатів. */
    private static final String FNAME = "items.bin";

    /** Значення за замовчуванням для кількості об'єктів SerializableClass. */
    private static final int DEFAULT_NUM = 10;

    /** Стек, що містить елементи для кожного стану результатів. */
    private final Stack<ArrayList<SerializableClass>> items = new Stack<>();

    /**
     * Конструктор, який ініціалізує список items зі значеннями SerializableClass за замовчуванням.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Конструктор, який ініціалізує список items з вказаною кількістю об'єктів SerializableClass.
     *
     * @param n кількість об'єктів SerializableClass для створення
     */
    public ViewResult(int n) {
        ArrayList<SerializableClass> list = new ArrayList<>();

        for (int ctr = 0; ctr < n; ctr++) {
            list.add(new SerializableClass());
        }

        items.push(list);
    }

    /**
     * Відміняє останню команду.
     */
    public void undo() {
        if (items.size() != 1) {
            items.pop();
        } else {
            System.out.println("Немає змін");
        }
    }

    /**
     * Метод для отримання списку елементів.
     *
     * @return список елементів
     */
    public ArrayList<SerializableClass> getItems() {
        return items.peek();
    }

    /**
     * Метод для ініціалізації значень напруги в елементах списку items з певним кроком.
     *
     * @param stepX крок для ініціалізації напруги
     */
    public void init(double stepX) {
        ArrayList<SerializableClass> list = new ArrayList<>();
        double voltage = 0.0;

        for (int i = 0; i < getItems().size(); i++) {
            SerializableClass results = new SerializableClass(voltage, new double[]{100, 200, 300});
            results.calculateCurrents();

            list.add(results);
            voltage += stepX;
        }

        items.push(list);
    }

    /**
     * Метод для випадкової ініціалізації значень напруги в елементах списку items.
     */
    public void viewInit() {
        init(Math.random() * 360.0);
    }

    /**
     * Метод для збереження списку items у файл.
     *
     * @throws IOException у випадку помилки вводу/виводу під час збереження
     */
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items.peek());
        os.flush();
        os.close();
    }

    /**
     * Метод для відновлення списку items з файлу.
     *
     * @throws Exception у випадку помилки під час відновлення
     */
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items.push((ArrayList<SerializableClass>) is.readObject());
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
        for (SerializableClass item : getItems()) {
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
