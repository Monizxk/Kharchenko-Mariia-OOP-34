package src.task6;

import src.task5.Command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Клас, який представляє чергу команд для виконання.
 */
public class CommandQueue {
    private Queue<Command> tasks;
    private boolean shutdown;

    /**
     * Конструктор для ініціалізації черги команд.
     */
    public CommandQueue() {
        tasks = new LinkedList<>();
        shutdown = false;
        new Thread(new Worker()).start();
    }

    /**
     * Додає команду до черги.
     * @param command команда, яку потрібно додати
     */
    public synchronized void put(Command command) {
        tasks.add(command);
        notify(); // Повідомляємо про нову команду
    }

    /**
     * Бере та видаляє першу команду з черги.
     * @return перша команда в черзі
     * @throws InterruptedException якщо потік був перерваний
     */
    public synchronized Command take() throws InterruptedException {
        while (tasks.isEmpty()) {
            wait(); // Чекаємо, поки не буде доступна нова команда
        }
        return tasks.poll();
    }

    /**
     * Зупиняє роботу черги команд.
     */
    public synchronized void shutdown() {
        shutdown = true;
        notifyAll(); // Повідомляємо всі потоки про закриття
    }

    /**
     * Клас-внутрішній робітник, який виконує команди з черги.
     */
    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!shutdown) {
                try {
                    Command command = take(); // Беремо команду з черги
                    command.execute(); // Виконуємо команду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
