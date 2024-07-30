package strategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiry;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cardExpiry, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiry = cardExpiry;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
        // Logic for paying with credit card goes here
    }
}
