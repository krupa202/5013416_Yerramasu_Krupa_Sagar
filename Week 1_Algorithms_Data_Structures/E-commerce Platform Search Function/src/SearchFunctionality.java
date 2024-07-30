import java.util.*;

class Product {
	private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
}

public class SearchFunctionality {
	public static Product linearSearch(Product[] products, String title) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(title)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String title) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(title);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter productId:");
    	String productId=sc.next();
    	System.out.println("Enter productName:");
    	String productName=sc.next();
    	System.out.println("Enter category:");
    	String category=sc.next();
    	System.out.println("Enter productId:");
    	String productId2=sc.next();
    	System.out.println("Enter productName:");
    	String productName2=sc.next();
    	System.out.println("Enter category:");
    	String category2=sc.next();
    	System.out.println("Enter productId:");
    	String productId3=sc.next();
    	System.out.println("Enter productName:");
    	String productName3=sc.next();
    	System.out.println("Enter category:");
    	String category3=sc.next();
        Product[] products = {
        		new Product(productId, productName, category),
        		new Product(productId2, productName2, category2),
        		new Product(productId3, productName3, category3)
        };
        System.out.println("Linear Search:");
        System.out.println("Enter productName to search:");
        String name=sc.next();
        Product foundProduct = linearSearch(products, name);
        System.out.println("Found: " + (foundProduct != null ? foundProduct.getProductName() : "null"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        System.out.println("Binary Search:");
        System.out.println("Enter productName to search:");
        name=sc.next();
        foundProduct = binarySearch(products, name);
        System.out.println("Found: " + (foundProduct != null ? foundProduct.getProductName() : "null"));
        sc.close();
    }
}
