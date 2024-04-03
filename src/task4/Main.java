package src.task4;

import src.task3.View;

/**
 * Клас Main є головним класом програми, який відповідає за запуск програми та ініціалізацію необхідних компонентів.
 */
public class Main extends src.task3.Main {

    /**
     * Конструктор класу Main, що приймає об'єкт типу View для ініціалізації батьківського класу.
     * @param view об'єкт типу View, який використовується для відображення результатів програми
     */
    public Main(View view) {
        super(view);
    }

    /**
     * Метод main є точкою входу в програму. Він створює об'єкт класу Main і запускає головне меню програми.
     * @param args аргументи командного рядка, які можуть передаватися при запуску програми (не використовується у цьому випадку)
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}

