import java.util.Scanner;
import java.util.ArrayList;

public class PizzaOrderApp {
    private int quantity;
    private String size;
    private String type;
    private double price;

    public PizzaOrderApp(int quantity, String size, String type, double price) {
        this.quantity = quantity;
        this.size = size;
        this.type = type;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        ArrayList<PizzaOrderApp> order = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // loop to allow the customer to select pizzas and sizes
        boolean ordering = true;
        while (ordering) {
            // display pizza menu
            System.out.println("Welcome to our pizza shop! Please select a pizza:");
            System.out.println("1. Cheese Pizza");
            System.out.println("2. Pepperoni Pizza");
            System.out.println("3. Veggie Pizza");

            // get user input for pizza selection
            int pizzaSelection = scanner.nextInt();

            // set pizza type based on selection
            String type;
            switch (pizzaSelection) {
                case 1:
                    type = "cheese";
                    break;
                case 2:
                    type = "pepperoni";
                    break;
                case 3:
                    type = "veggie";
                    break;
                default:
                    System.out.println("Invalid pizza selection");
                    continue;
            }

            // display size options
            System.out.println("Please select a size:");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");

            // get user input for size selection
            int sizeSelection = scanner.nextInt();

            // set size based on selection
            String size;
            switch (sizeSelection) {
                case 1:
                    size = "small";
                    break;
                case 2:
                    size = "medium";
                    break;
                case 3:
                    size = "large";
                    break;
                default:
                    System.out.println("Invalid size selection");
                    continue;
            }

            // get user input for quantity
            System.out.println("Please enter the quantity:");
            int quantity = scanner.nextInt();

            // calculate price based on selections
            double price = calculatePrice(size, quantity);

            // add pizza order to order ArrayList
            PizzaOrderApp pizzaOrder = new PizzaOrderApp(quantity, size, type, price);
            order.add(pizzaOrder);

            // ask if customer wants to order another pizza
            System.out.println("Do you want to order another pizza? (Y/N)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("N")) {
                ordering = false;
            }
        }

        // display summary of order
        double total = 0.0;
        System.out.println("Order Summary:");
        for (PizzaOrderApp pizza : order) {
            System.out.println(pizza.getQuantity() + " " + pizza.getSize() + " " + pizza.getType());
        }
    }

    private static double calculatePrice(String size2, int quantity2) {
        return 0;
    }
}
