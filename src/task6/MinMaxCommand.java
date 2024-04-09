package src.task6;

import src.task2.SerializableClass;
import src.task3.ViewResult;
import src.task5.Command;

import java.util.concurrent.TimeUnit;

public class MinMaxCommand implements Command {
    private int resultMin = -1;
    private int resultMax = -1;
    private int progress = 0;

    private ViewResult viewResult;

    public ViewResult getViewResult() {
        return viewResult;
    }

    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public int getResultMin() {
        return resultMin;
    }

    public int getResultMax() {
        return resultMax;
    }

    public boolean running() {
        return progress < 100;
    }

    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (SerializableClass item : viewResult.getItems()) {
            if (item.getVoltage() < 0) {
                if (resultMax == -1 || item.getVoltage() > viewResult.getItems().get(resultMax).getVoltage()) {
                    resultMax = idx;
                }
            } else {
                if (resultMin == -1 || item.getResistances()[0] < viewResult.getItems().get(resultMin).getResistances()[0]) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " +
                    String.format("%.2f.", viewResult.getItems().get(resultMin).getResistances()[0]));
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: " +
                    String.format("%.2f.", viewResult.getItems().get(resultMax).getResistances()[0]));
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }

}
