package src.task4;

import src.task2.SerializableClass;
import src.task3.View;
import src.task3.ViewResult;

import java.util.Formatter;

/**
 * Клас для відображення результатів у вигляді таблиці.
 */
public class ViewTable extends ViewResult {

    private int width;

    /**
     * Конструктор за замовчуванням, що встановлює ширину таблиці.
     */
    public ViewTable() {
        this.width = 20; // ширина таблиці за замовчуванням
    }

    /**
     * Конструктор, що приймає ширину таблиці.
     * @param width ширина таблиці
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Перевизначений метод для відображення заголовка таблиці.
     * @overriding
     */
    @Override
    public void viewHeader() {
        outLineLn();
        outHeader();
        outLineLn();
    }

    /**
     * Перевизначений метод для відображення тіла таблиці.
     * @overriding
     */
    @Override
    public void viewBody() {
        outBody();
    }

    /**
     * Перевизначений метод для відображення підзаголовка таблиці.
     * @overriding
     */
    @Override
    public void viewFooter() {
        outLineLn();
    }

    /**
     * Метод для відображення рядка з символами '-'.
     */
    private void outLine() {
        for(int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /**
     * Метод для відображення рядка з символами '-' та переведення рядка.
     */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /**
     * Метод для відображення заголовка таблиці.
     */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Voltage", "Resistance");
    }

    /**
     * Перевантажений метод для відображення тіла таблиці для об'єктів типу SerializableClass.
     * @overloading
     */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, ".2f | %", ".2f\n");
        for(SerializableClass item : getItems()) {
            System.out.printf(fmt.toString(), item.getVoltage(), item.getResistances()[0]);
        }
    }

    /**
     * Метод, який використовує поліморфізм для виклику відповідного методу outBody().
     * @dynamic method dispatch
     */
    public void viewBody(Object data) {
        if (data instanceof SerializableClass) {
            outBody((SerializableClass) data);
        } else if (data instanceof double[]) {
            outBody((double[]) data);
        } else {
            throw new IllegalArgumentException("Invalid data type");
        }
    }

    /**
     * Перевантажений метод для відображення тіла таблиці для об'єктів типу SerializableClass.
     * @overloading
     */
    private void outBody(SerializableClass data) {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, ".2f | %", ".2f\n");
        System.out.printf(fmt.toString(), data.getVoltage(), data.getResistances()[0]);
    }

    /**
     * Перевантажений метод для відображення тіла таблиці для масивів типу double.
     * @overloading
     */
    private void outBody(double[] data) {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, ".2f | %", ".2f\n");
        for(double value : data) {
            System.out.printf(fmt.toString(), value, 0.0);
        }
    }
}
