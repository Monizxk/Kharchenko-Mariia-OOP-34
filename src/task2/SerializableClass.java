package src.task2;
import java.io.Serializable;

public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private double voltage;
    private double[] resistances;

    public SerializableClass(double voltage, double[] resistances) {
        this.voltage = voltage;
        this.resistances = resistances;
    }

    public double[] calculateCurrents() {
        double[] currents = new double[resistances.length];
        for(int i = 0; i < resistances.length; i++) { // Правильний оператор порівняння
            currents[i] = voltage / resistances[i];
        }
        return currents;
    }

    @Override // Переміщення методу toString() в тіло класу
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
