package src.task2;
/**
 * Клас для представлення об'єкта, який може бути серіалізований.
 */
import java.io.Serializable;

public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private double voltage; // Напруга
    private double[] resistances; // Масив опорів

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
        double[] currents = new double[resistances.length];
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
}
