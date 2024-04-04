package src.task5;

/**
 * Інтерфейс, який представляє консольну команду.
 * Розширює інтерфейс Command.
 */
public interface ConsoleCommand extends Command {

    /**
     * Отримує ключ команди.
     * @return ключ команди
     */
    public char getKey();
}

