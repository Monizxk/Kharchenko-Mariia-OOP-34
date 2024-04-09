package src.task6;

import src.task3.View;
import src.task4.ViewableTable;
import src.task5.*;

public class Main {
    private View view = new ViewableTable().getView();

    private Menu menu = new Menu();

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

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
