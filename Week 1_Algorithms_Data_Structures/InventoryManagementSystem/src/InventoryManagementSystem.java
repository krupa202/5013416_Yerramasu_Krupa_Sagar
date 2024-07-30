import java.util.HashMap;
import java.util.Scanner;
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct == null) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        System.out.println("Enter productId:");
        String productId = sc.next();
        System.out.println("Enter productName:");
        String productName = sc.next();
        System.out.println("Enter Quantity:");
        int quantity = sc.nextInt();
        System.out.println("Enter price:");
        double price = sc.nextDouble();
        
        Product p1 = new Product(productId, productName, quantity, price);
        ims.addProduct(p1);
        
        System.out.println("Enter the productId to fetch:");
        productId=sc.next();
        Product fetchedProduct = ims.getProduct(productId);
        if (fetchedProduct != null) {
            System.out.println("Fetched Product: " + fetchedProduct.getProductName() + ", Quantity: " + fetchedProduct.getQuantity() + ", Price: " + fetchedProduct.getPrice());
        } else {
            System.out.println("Product not found.");
        }
        
        System.out.println("Enter the productId to update:");
        productId=sc.next();
        System.out.println("Enter the quantity to update:");
        quantity=sc.nextInt();
        System.out.println("Enter the price to update:");
        price=sc.nextDouble();
        ims.updateProduct(productId, quantity, price);
        fetchedProduct = ims.getProduct(productId);
        if (fetchedProduct != null) {
            System.out.println("Updated Product: " + fetchedProduct.getProductName() + ", Quantity: " + fetchedProduct.getQuantity() + ", Price: " + fetchedProduct.getPrice());
        } else {
            System.out.println("Product not found.");
        }

        ims.deleteProduct(productId);
        fetchedProduct = ims.getProduct(productId);
        if (fetchedProduct == null) {
            System.out.println("Deleted Product: null");
        } else {
            System.out.println("Deleted Product: " + fetchedProduct.getProductName());
        }
        
        sc.close();
    }
}
