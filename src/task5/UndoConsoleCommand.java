package src.task5;

import src.task3.View;

/**
 * Представляє консольну команду для скасування останньої дії.
 */
public class UndoConsoleCommand implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private View view;

    /**
     * Конструктор команди скасування.
     * @param view представлення
     */
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 'u';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "'u'ndo";
    }

    /**
     * Виконує команду скасування.
     * Викликає метод скасування останньої дії, відновлює дані та відображає їх.
     */
    public void execute() {
        view.undo();
    }
}
