package src.task5;

import src.task2.SerializableClass;
import src.task3.ViewResult;

/**
 * Представляє команду зміни елемента.
 */
public class ChangeItemCommand {
    /** Елемент, який буде змінено. */
    private SerializableClass item;

    /** Зміщення для зміни. */
    private double offset;

    /**
     * Встановлює елемент, який буде змінено.
     * @param item елемент
     * @return елемент
     */
    public SerializableClass setItem(SerializableClass item) {
        return this.item = item;
    }

    /**
     * Отримує елемент, який буде змінено.
     * @return елемент
     */
    public SerializableClass getItem() {
        return item;
    }

    /**
     * Встановлює зміщення для зміни.
     * @param offset зміщення
     * @return зміщення
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }

    /**
     * Отримує зміщення для зміни.
     * @return зміщення
     */
    public double getOffset() {
        return offset;
    }

    /**
     * Виконує команду зміни.
     * Множить напругу елемента на зміщення.
     */
    public void execute() {
        ViewResult view = new ViewResult();
        item.setVoltage(item.getVoltage() * offset);
    }
}
