package src.task6;

import src.task2.SerializableClass;
import src.task3.View;
import src.task3.ViewResult;
import src.task5.Command;
import src.task5.ConsoleCommand;

import java.util.concurrent.TimeUnit;

public class ExecuteConsoleCommand implements ConsoleCommand {
    private View view;

    public View getView() {
        return view;
    }

    public View setView(View view) {
        return this.view = view;
    }

    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    public char getKey() {
        return 'e';
    }

    public String toString() {
        return "'e'xecute";
    }

    public void execute() {
        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        MinMaxCommand minMaxCommand = new MinMaxCommand((ViewResult)view);
        MaxCommand maxCommand = new MaxCommand((ViewResult)view);
        AvgCommand avgCommand = new AvgCommand((ViewResult)view);
        System.out.println("Execute all threads...");

        queue1.put(minMaxCommand);
        queue2.put(maxCommand);
        queue2.put(avgCommand);

        try {
            while (avgCommand.running() ||
                    maxCommand.running() ||
                    minMaxCommand.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }

            queue1.shutdown();
            queue2.shutdown();

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("All done.");
    }
}
