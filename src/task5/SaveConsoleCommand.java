package src.task5;

import src.task3.View;

import java.io.IOException;

/**
 * Представляє консольну команду для збереження даних.
 */
public class SaveConsoleCommand implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private View view;

    /**
     * Конструктор команди збереження.
     * @param view представлення
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 's';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "'s'ave";
    }

    /**
     * Виконує команду збереження.
     * Виводить повідомлення про збереження поточних даних,
     * зберігає дані у файл та відображає їх.
     */
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }

}
