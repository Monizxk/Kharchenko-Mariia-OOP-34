package src.task6;

import src.task3.View;
import src.task4.ViewableTable;
import src.task5.*;

/**
 * Клас, що містить точку входу в програму та викликає основний функціонал.
 */
public class Main {
    private View view = new ViewableTable().getView();
    private Menu menu = new Menu();

    /**
     * Метод, що запускає програму та викликає головну функцію.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    /**
     * Метод, що викликає функцію виконання основного функціоналу програми.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }
}
