package src.task4;

import src.task3.View;
import src.task3.ViewableResult;

/**
 * Клас, який реалізує інтерфейс Viewable та надає об'єкт типу ViewTable.
 */
public class ViewableTable extends ViewableResult {

    /**
     * Метод для отримання об'єкта типу ViewTable.
     * @return об'єкт типу ViewTable
     */
    public View getView() {
        return new ViewTable();
    }
}
