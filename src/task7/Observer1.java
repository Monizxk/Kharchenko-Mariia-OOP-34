package src.task7;

import java.util.Objects;

/**
 * Спостерігач який оновлюється при натисканні на кнопки generate та undo
 */
public class Observer1 implements Observer {
    /** Оновлює спостерігача */
    public void update(String message) {
        if (Objects.equals(message, "generate") || Objects.equals(message, "undo")) {
            System.out.println("OBSERVER 1: " + message);
        }
    }
}
