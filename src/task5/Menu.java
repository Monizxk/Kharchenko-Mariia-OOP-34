package src.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Представляє меню команд для консольного інтерфейсу.
 * Реалізує інтерфейс Command.
 */
public class Menu implements Command {

    /** Список консольних команд. */
    private List<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();

    /**
     * Додає консольну команду до меню.
     * @param command консольна команда
     * @return додана команда
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    /**
     * Повертає рядок з представленням меню.
     * @return рядок з представленням меню
     */
    public String toString() {
        String s = "Enter command...\n";
        for (ConsoleCommand c : menu) {
            s += c + ", ";
        }
        s += "'q'uit: ";
        return s;
    }

    /**
     * Виконує команди з меню.
     * Очікує введення команд з консолі, виконує відповідну команду
     * або виходить з програми при введенні 'q'.
     */
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu:
        while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Exit.");
                break menu;
            }
            for (ConsoleCommand c : menu) {
                if (s.charAt(0) == c.getKey()) {
                    c.execute();
                    continue menu;
                }
            }
            System.out.println("Wrong command.");
            continue menu;
        }
    }

}
