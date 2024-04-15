package src.task7;

import java.util.Objects;

/**
 * Спостерігач який оновлюється при натисканні на кнопки save та restore
 */
public class Observer2 implements Observer {
    /** Оновлює спостерігача */
    public void update(String message) {
        if (Objects.equals(message, "save") || Objects.equals(message, "restore")) {
            System.out.println("OBSERVER 2: " + message);
        }
    }
}
