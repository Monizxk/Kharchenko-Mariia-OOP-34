package src.task5;

import src.task3.View;

/**
 * Представляє консольну команду для генерації даних.
 */
public class GenerateConsoleCommand implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private final View view;

    /**
     * Конструктор команди генерації.
     * @param view представлення
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 'g';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "g'enerate";
    }

    /**
     * Виконує команду генерації.
     * Виводить повідомлення про випадкову генерацію даних,
     * ініціалізує представлення та відображає його.
     */
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}
