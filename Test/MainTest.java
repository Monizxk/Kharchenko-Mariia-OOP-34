package Test;

import src.task2.SerializableClass;

import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Клас для тестування головного класу програми Main.
 */
public class MainTest {
    /**
     * Метод для тестування обчислення поточних значень.
     */
    @org.junit.Test
    public void testCalculate() {

        SerializableClass serializableClass = new SerializableClass();
        serializableClass.setResistances(new double[]{100.0, 200.0, 300.0});
        serializableClass.setVoltage(24);
        assertArrayEquals(new double[]{0.24, 0.12, 0.08}, serializableClass.calculateCurrents(), 0.01);
        serializableClass.setVoltage(48);
        assertArrayEquals(new double[]{0.48, 0.24, 0.16}, serializableClass.calculateCurrents(), 0.01);
        serializableClass.setVoltage(78);
        assertArrayEquals(new double[]{0.78, 0.39, 0.26}, serializableClass.calculateCurrents(), 0.01);

    }
    /**
     * Метод для тестування серіалізації та десеріалізації об'єктів класу SerializableClass.
     * @throws IOException у випадку помилки вводу/виводу під час серіалізації/десеріалізації
     * @throws ClassNotFoundException якщо клас не може бути знайдений при десеріалізації
     */
    @org.junit.Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        SerializableClass serializableClass = new SerializableClass();
        serializableClass.setResistances(new double[]{100.0, 200.0, 300.0});
        serializableClass.setVoltage(24);
        serializableClass.calculateCurrents();

        serializableClass.serialize();
        SerializableClass deserializedClass = SerializableClass.deserialize();

        assertArrayEquals(serializableClass.getCurrents(), deserializedClass.getCurrents(), 0.01);
    }
}