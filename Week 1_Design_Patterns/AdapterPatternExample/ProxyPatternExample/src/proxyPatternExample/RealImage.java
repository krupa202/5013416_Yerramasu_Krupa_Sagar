package proxyPatternExample;

public class RealImage implements Image {
	   private String filename;

	    public RealImage(String filename) {
	        this.filename = filename;
	        loadImageFromDisk();
	    }

	    private void loadImageFromDisk() {
	        System.out.println("Loading image " + filename);
	        // Simulate loading image from a remote server
	        try {
	            Thread.sleep(2000); // Simulating a delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void display() {
	        System.out.println("Displaying image " + filename);
	    }

}
