public class TestCalculation {
    public static void main(String[] arg) {
        CalculationResult testResult = new CalculationResult(5, 10 , 50);

        if ((int) testResult.getResult() == 50) {
            System.out.println("Результати обчислень коректні: true");
        } else {
            System.out.println("Результати обчислень коректні: false");
        }
    }
}