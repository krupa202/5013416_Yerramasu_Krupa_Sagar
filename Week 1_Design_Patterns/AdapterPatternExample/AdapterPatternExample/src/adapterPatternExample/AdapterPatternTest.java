package adapterPatternExample;

public class AdapterPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Create instances of the payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();

        // Create adapter instances
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Process payments through different gateways using the adapters
        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
	}

}
