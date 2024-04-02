package src.task3;

import java.io.IOException;

/**
 * Інтерфейс, що визначає методи для взаємодії з відображенням.
 */
public interface View {

    /**
     * Метод для відображення заголовку.
     */
    public void viewHeader();

    /**
     * Метод для відображення тіла.
     */
    public void viewBody();

    /**
     * Метод для відображення нижнього колонтитулу.
     */
    public void viewFooter();

    /**
     * Метод для відображення всієї інформації.
     */
    public void viewShow();

    /**
     * Метод для ініціалізації відображення.
     */
    public void viewInit();

    /**
     * Метод для збереження стану відображення.
     * @throws IOException у випадку помилки вводу/виводу під час збереження
     */
    public void viewSave() throws IOException;

    /**
     * Метод для відновлення останнього збереженого стану відображення.
     * @throws Exception у випадку помилки під час відновлення
     */
    public void viewRestore() throws Exception;

}
