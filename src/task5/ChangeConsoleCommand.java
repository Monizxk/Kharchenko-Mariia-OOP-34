package src.task5;

import src.task2.SerializableClass;
import src.task3.View;
import src.task3.ViewResult;

import java.util.Random;

/**
 * Представляє команду для зміни елемента у консольному інтерфейсі.
 * Реалізує інтерфейси ChangeItemCommand та ConsoleCommand.
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {

    /** Представлення, з яким працює команда. */
    private View view;

    /**
     * Отримує представлення, з яким буде працювати команда.
     * @return представлення
     */
    public View getView() {
        return view;
    }

    /**
     * Встановлює представлення, з яким буде працювати команда.
     * @param view представлення
     * @return представлення
     */
    public View setView(View view) {
        return this.view = view;
    }

    /**
     * Конструктор команди зміни.
     * @param view представлення
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey() {
        return 'c';
    }

    /**
     * Повертає рядок, який представляє команду.
     * @return рядок з представленням команди
     */
    public String toString() {
        return "'c'hange";
    }

    /**
     * Виконує команду зміни.
     * Змінює масштаб елемента у випадковому діапазоні,
     * після чого відображає змінений елемент.
     */
    public void execute() {
        Random random = new Random();

        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (SerializableClass item : ((ViewResult) view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}
