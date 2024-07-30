package observerPatternExample;

public class ObserverPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        // Register observers
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        // Set new stock price and notify observers
        System.out.println("Setting stock price to 100.00");
        stockMarket.setStockPrice(100.00);

        // Deregister an observer and set new stock price
        stockMarket.deregisterObserver(mobileApp1);
        System.out.println("\nSetting stock price to 150.00");
        stockMarket.setStockPrice(150.00);

	}

}
