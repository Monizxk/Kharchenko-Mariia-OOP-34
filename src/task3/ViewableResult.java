package src.task3;

/**
 * Клас, що реалізує інтерфейс Viewable і надає об'єкт типу ViewResult.
 */
public class ViewableResult implements Viewable {

    /**
     * Метод для отримання об'єкта типу ViewResult.
     * @return об'єкт типу ViewResult
     */
    public View getView() {
        return new ViewResult();
    }
}
