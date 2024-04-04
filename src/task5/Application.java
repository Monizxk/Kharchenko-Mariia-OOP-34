/**
 * Представляє додаток для управління переглядовим таблицям.
 * Цей додаток забезпечує інтерфейс на основі меню для виконання різних операцій,
 * таких як перегляд, генерація, зміна, збереження, відновлення та скасування змін на таблиці.
 */
package src.task5;

import src.task3.View;
import src.task4.ViewableTable;

public class Application {

    /** Єдиний екземпляр класу Application. */
    private static final Application instance = new Application();

    /** Приватний конструктор для запобігання створенню екземплярів зовнішніми. */
    private Application() {
    }

    /**
     * Отримує єдиний екземпляр класу Application.
     * @return екземпляр класу Application
     */
    public static Application getInstance() {
        return instance;
    }

    /** Представлення, пов'язане з додатком. */
    private final View view = new ViewableTable().getView();

    /** Меню, пов'язане з додатком. */
    private final Menu menu = new Menu();

    /**
     * Запускає додаток.
     * Ініціалізує меню командами для перегляду, генерації, зміни, збереження,
     * відновлення та скасування змін на таблиці та виконує меню.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }
}
