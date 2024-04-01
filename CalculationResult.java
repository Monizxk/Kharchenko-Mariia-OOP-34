import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CalculationResult {
    private double parameter1;
    private double parameter2;
    private double result;

    public CalculationResult(int i, int j, int k) {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        CalculationResult deserializedResult = null; 
        
        try {
            FileInputStream fileIn = new FileInputStream("calc_result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedResult = (CalculationResult) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Об'єкт десеріалізовано з файлу calc_result.ser");            
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double getParameter1() {
        return getParameter1();
    }

    public void setParameter1(double parameter1) {
        this.parameter1 = parameter1;
    }

    public double getParameter2() {
        return getParameter2();
    }

    public void setParameter2(double parameter2) {
        this.parameter2 = parameter2;
    }

    public double getResult() {
        return parameter1 * parameter2; 
    }

    public void setResult(double result) {
        this.result = result;
    }
}
