package proxyPatternExample;

public class ProxyPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Image image1 = new ProxyImage("image1.jpg");
	        Image image2 = new ProxyImage("image2.jpg");

	        // Load and display image1
	        System.out.println("First time loading and displaying image1:");
	        image1.display();

	        // Load and display image2
	        System.out.println("\nFirst time loading and displaying image2:");
	        image2.display();

	        // Display image1 again, this time it should be loaded from cache
	        System.out.println("\nDisplaying image1 again:");
	        image1.display();

	}

}
