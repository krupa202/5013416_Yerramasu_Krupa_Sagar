package strategyPatternExample;

public class StrategyPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PaymentContext context = new PaymentContext();

	        // Pay with Credit Card
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "12/23", "123");
	        context.setPaymentStrategy(creditCardPayment);
	        context.pay(250.00);

	        // Pay with PayPal
	        PaymentStrategy payPalPayment = new PayPalPayment("johndoe@example.com", "password123");
	        context.setPaymentStrategy(payPalPayment);
	        context.pay(100.00);

	}

}
