package src.task5;

import java.io.IOException;
import java.util.Stack;
import src.task3.View;
import src.task3.ViewResult;

/**
 * Клас, що відповідає за резервне збереження та скасування дій.
 */
public class UndoReserve {
    /** Стек для збереження історії станів. */
    private Stack<ViewResult> history = new Stack<>();
    /** Представлення, з яким працює об'єкт. */
    private View view;

    /**
     * Конструктор класу UndoReserve.
     * @param view представлення
     */
    public UndoReserve(View view) {
        this.view = view;
    }

    /**
     * Зберігає поточний стан представлення.
     */
    public void saveState() {
        try {
            ViewResult currentState = new ViewResult();
            view.viewSave();
            history.push(currentState);
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     * Відновлює попередній стан представлення.
     */
    public void undo() {
        if (!history.isEmpty()) {
            ViewResult previousState = history.pop();
            try {
                view.viewRestore();
                view.viewShow();
            } catch (Exception e) {
                System.err.println("Error restoring state: " + e.getMessage());
            }
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
