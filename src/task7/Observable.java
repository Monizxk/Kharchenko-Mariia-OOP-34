package src.task7;

/**
 * Інтерйейс для класу який буде спостерігатися
 */
public interface Observable {
    /** Оновлює спостерігача */
    public void update(String message);

    /**  Додає спостерігача в список спостерігачів */
    public void addObserver(Observer observer);
}
