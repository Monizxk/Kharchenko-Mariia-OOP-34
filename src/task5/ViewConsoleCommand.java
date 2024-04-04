package src.task5;

import src.task3.View;

/**
 * Представляє консольну команду для перегляду даних.
 */
public class ViewConsoleCommand implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private View view;

    /**
     * Конструктор команди перегляду.
     * @param view представлення
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 'v';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "'v'iew";
    }

    /**
     * Виконує команду перегляду.
     * Виводить повідомлення про перегляд поточних даних та відображає їх.
     */
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}
