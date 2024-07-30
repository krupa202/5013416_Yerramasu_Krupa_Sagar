import java.util.*;
public class FinancialForecastingTool {
	// Recursive method to predict future value
    public static double predictFutureValue(double PV, double r, int n) {
        // Base case: if the number of periods is 0, return the present value
        if (n == 0) {
            return PV;
        }
        // Recursive case: calculate the value for the current period and call the method for the next period
        return predictFutureValue(PV, r, n - 1) * (1 + r);
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
        double futureValue = predictFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
