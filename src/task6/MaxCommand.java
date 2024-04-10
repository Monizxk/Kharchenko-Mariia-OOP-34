package src.task6;

import src.task3.ViewResult;
import src.task5.Command;

import java.util.concurrent.TimeUnit;

/**
 * Клас, що представляє команду для пошуку максимального значення напруги.
 */
public class MaxCommand implements Command {
    private int result = -1;
    private int progress = 0;
    private ViewResult viewResult;

    /**
     * Конструктор класу MaxCommand.
     *
     * @param viewResult об'єкт ViewResult, з яким працює команда
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Повертає індекс елемента з максимальною напругою.
     *
     * @return індекс елемента з максимальною напругою
     */
    public int getResult() {
        return result;
    }

    /**
     * Перевіряє, чи виконується команда.
     *
     * @return true, якщо команда виконується, інакше - false
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Виконує пошук максимального значення напруги.
     */
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(result).getVoltage() <
                    viewResult.getItems().get(idx).getVoltage()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        progress = 100;
    }
}
