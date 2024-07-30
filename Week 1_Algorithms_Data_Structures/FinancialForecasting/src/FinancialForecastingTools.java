import java.util.HashMap;
import java.util.Scanner;

public class FinancialForecastingTools {

    private static HashMap<Integer, Double> memo = new HashMap<>();

    // Recursive method with memoization to predict future value
    public static double predictFutureValueMemo(double PV, double r, int n) {
        // Check if the result for the current period is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // Base case: if the number of periods is 0, return the present value
        if (n == 0) {
            return PV;
        }
        // Recursive case: calculate the value for the current period and call the method for the next period
        double result = predictFutureValueMemo(PV, r, n - 1) * (1 + r);
        memo.put(n, result);
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter present value:");
        double presentValue = sc.nextDouble();
        System.out.println("Enter growth rate:");
        double growthRate = sc.nextDouble();  // 5%
        System.out.println("Enter periods:");
        int periods = sc.nextInt();
        double futureValue = predictFutureValueMemo(presentValue, growthRate, periods);
        System.out.println("Future Value with Memoization: " + futureValue);
    }
}
