package src.task6;

import src.task2.SerializableClass;
import src.task3.ViewResult;
import src.task5.Command;

import java.util.concurrent.TimeUnit;

/**
 * Клас AvgCommand реалізує інтерфейс Command і відповідає за обчислення середнього значення в наперед заданому списку об'єктів SerializableClass.
 */
public class AvgCommand implements Command {

    /** Змінна, що зберігає результат середнього значення. */
    private double result = 0.0;

    /** Змінна, що зберігає прогрес виконання команди. */
    private int progress = 0;

    /** Об'єкт, що містить результати для обчислення середнього значення. */
    private ViewResult viewResult;

    /**
     * Конструктор класу AvgCommand.
     *
     * @param viewResult Об'єкт, що містить результати для обчислення середнього значення.
     */
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає результат середнього значення.
     *
     * @return Результат середнього значення.
     */
    public double getResult() {
        return result;
    }

    /**
     * Перевіряє, чи команда все ще виконується.
     *
     * @return true, якщо команда все ще виконується, в іншому випадку - false.
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Виконує обчислення середнього значення.
     */
    public void execute() {
        progress = 0;
        System.out.println("Average executed...");
        result = 0.0;
        int idx = 1, size = viewResult.getItems().size();
        for (SerializableClass item : viewResult.getItems()) {
            result += item.getVoltage();
            progress = idx * 100 / size;

            if (idx++ % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        result /= size;
        System.out.println("Average done. Result = " + String.format("%.2f",result));
        progress = 100;
    }
}

