package src.task5;

import src.task3.View;

/**
 * Представляє консольну команду для відновлення даних.
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private View view;

    /**
     * Конструктор команди відновлення.
     * @param view представлення
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 'r';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "'r'estore";
    }

    /**
     * Виконує команду відновлення.
     * Виводить повідомлення про відновлення останніх збережених даних,
     * відновлює дані з файлу та відображає їх.
     */
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
