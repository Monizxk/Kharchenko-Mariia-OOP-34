package Test;

import src.task2.SerializableClass;
import src.task3.View;
import src.task3.ViewResult;
import src.task4.ViewableTable;
import src.task5.Application;
import src.task6.ExecuteConsoleCommand;
import src.task6.MinMaxCommand;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import java.io.*;

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

    /**
     * Метод для тестування скасування останньої команди.
     */
    @org.junit.Test
    public void testUndo() {
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("u\nq".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);

        Application app = Application.getInstance();
        app.run();

        String output = outputStream.toString();

        assertTrue(output.contains("Undo last command."));
        assertTrue(output.contains("Exit."));

        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Метод для тестування WorkThread
     */
    @org.junit.Test
    public void testExecute() {
        View view = new ViewableTable().getView();
        ExecuteConsoleCommand executeConsoleCommand = new ExecuteConsoleCommand(view);

        executeConsoleCommand.execute();

        String output = outContent.toString().trim();

        assert output.contains("Average done. Result = 342.38");
        assert output.contains("MinMax done. Min positive #0 found: 100.00.");
        assert output.contains("Max negative item not found.");
    }
}
