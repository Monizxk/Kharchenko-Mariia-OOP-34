package src.task2;
/**
 * Клас для представлення об'єкта, який може бути серіалізований.
 */
import java.io.*;

public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private double voltage; // Напруга
    private double[] resistances; // Масив опорів

    double[] currents;


    /**
     * Конструктор класу.
     *  * @param voltage напруга
     *  * @param resistances масив опорів
     */
    public SerializableClass() {
        this.voltage = 10;
        this.resistances = new double[]{100, 200, 300};
    }

    /**
     * Конструктор класу.
     * @param voltage напруга
     * @param resistances масив опорів
     */
    public SerializableClass(double voltage, double[] resistances) {
        this.voltage = voltage;
        this.resistances = resistances;
    }

    /**
     * Обчислює сили струму через кожен опір.
     * @return масив сил струму
     */
    public double[] calculateCurrents() {

        currents = new double[resistances.length];
        for(int i = 0; i < resistances.length; i++) { // Правильний оператор порівняння
            currents[i] = voltage / resistances[i];
        }
        return currents;
    }

    /**
     * Перетворює результати обчислень у рядок.
     * @return рядок з результатами обчислень
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        double[] currents = calculateCurrents();
        for (int i = 0; i < resistances.length; i++) {
            resultString.append("Двійкове представлення сили струму через опір ").append(i + 1).append(": ");
            resultString.append(Double.toString((long) currents[i])).append("\n");
        }
        return resultString.toString();
    }

    /**
     * Метод для отримання масиву сил струму.
     * @return масив сил струму
     */
    public double[] getCurrents() {
        return currents;
    }

    /**
     * Метод для встановлення масиву сил струму.
     * @param currents масив сил струму
     */
    public void setCurrents(double[] currents) {
        this.currents = currents;
    }
    public double getVoltage() {
        return voltage;
    }

    /**
     * Метод для отримання напруги.
     * @return напруга
     */
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    /**
     * Метод для встановлення напруги.
     */
    public double[] getResistances() {
        return resistances;
    }

    /**
     * Метод для отримання масиву опорів.
     * @return масив опорів
     */
    public void setResistances(double[] resistances) {
        this.resistances = resistances;
    }
    /**
     * Метод для серіалізації об'єкта класу.
     * @throws IOException у випадку помилки під час серіалізації
     */
    public void serialize() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Serializable.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        }
    }

    /**
     * Метод для десеріалізації об'єкта класу.
     * @return десеріалізований екземпляр класу
     * @throws IOException у випадку помилки під час десеріалізації
     * @throws ClassNotFoundException якщо клас не може бути знайдений під час десеріалізації
     */
    public static SerializableClass deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("Serializable.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (SerializableClass) objectInputStream.readObject();
        }
    }
}
