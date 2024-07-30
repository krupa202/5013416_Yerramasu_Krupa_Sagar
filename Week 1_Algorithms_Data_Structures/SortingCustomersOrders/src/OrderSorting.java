import java.util.*;
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }
}
public class OrderSorting {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of orders:");
        int n = sc.nextInt();
        sc.nextLine();  // Consume the newline

        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter orderId for order " + (i + 1) + ":");
            String orderId = sc.nextLine();
            System.out.println("Enter customerName for order " + (i + 1) + ":");
            String customerName = sc.nextLine();
            System.out.println("Enter totalPrice for order " + (i + 1) + ":");
            double totalPrice = sc.nextDouble();
            sc.nextLine();  // Consume the newline

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Before Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }

        bubbleSort(orders);

        System.out.println("After Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }

        // Creating a new array for quick sort demonstration
        Order[] orders2 = new Order[n];
        System.arraycopy(orders, 0, orders2, 0, n);

        System.out.println("Before Quick Sort:");
        for (Order order : orders2) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("After Quick Sort:");
        for (Order order : orders2) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }
    }
}