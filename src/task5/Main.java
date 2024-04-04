package src.task5;

/**
 * Клас, що містить метод main для запуску.
 */
public class Main {
    /**
     * Точка входу в програму.
     * Створює єдиний екземпляр та запускає його.
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}

