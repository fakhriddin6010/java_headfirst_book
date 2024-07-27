import java.util.Scanner;

public class PizzaOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOrdering = true;
        OrderItem[] orderItems = new OrderItem[5]; // assuming there are 5 pizza menu items

        // Display pizza menu
        System.out.println("Welcome to our online pizza store!");
        System.out.println("Please select a pizza menu (1-5):");
        System.out.println("1. Margherita Pizza - $10.99");
        System.out.println("2. Pepperoni Pizza - $12.99");
        System.out.println("3. Veggie Pizza - $11.99");
        System.out.println("4. BBQ Chicken Pizza - $13.99");
        System.out.println("5. Hawaiian Pizza - $12.99");

        while (isOrdering) {
            int pizzaChoice = scanner.nextInt();
            if (pizzaChoice >= 1 && pizzaChoice <= 5) {
                // Display pizza size menu
                System.out.println("Please select a pizza size (1-4):");
                System.out.println("1. Small - $0.00");
                System.out.println("2. Medium - $2.00");
                System.out.println("3. Large - $4.00");
                System.out.println("4. Extra Large - $6.00");

                int sizeChoice = scanner.nextInt();
                if (sizeChoice >= 1 && sizeChoice <= 4) {
                    // Get quantity
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    if (quantity > 0) {
                        double price = 0.0;
                        switch (sizeChoice) {
                            case 1:
                                price = 10.99;
                                break;
                            case 2:
                                price = 12.99;
                                break;
                            case 3:
                                price = 11.99;
                                break;
                            case 4:
                                price = 13.99;
                                break;
                        }
                        OrderItem orderItem = new OrderItem(pizzaChoice, sizeChoice, quantity, price);
                        orderItems[pizzaChoice - 1] = orderItem; // store the order item in the orderItems array
                        System.out.println("Order added to cart.");
                    } else {
                        System.out.println("Invalid quantity. Please enter a valid quantity.");
                    }
                } else {
                    System.out.println("Invalid pizza size choice. Please enter a valid pizza size choice.");
                }
            } else if (pizzaChoice == 6) {
                // Exit ordering
                isOrdering = false;
            } else {
                System.out.println("Invalid pizza choice. Please enter a valid pizza choice.");
            }
        }
    }
}

class OrderItem {
    private int pizzaChoice;
    private int sizeChoice;
    private int quantity;
    private double price;

    public OrderItem(int pizzaChoice, int sizeChoice, int quantity, double price) {
        this.pizzaChoice = pizzaChoice;
        this.sizeChoice = sizeChoice;
        this.quantity = quantity;
        this.price = price;
    }

    // getter and setter methods

    @Override
    public String toString() {
        return quantity + " " + getSizeString() + " " + getSizeString() + " - $" + (price * quantity)

    /**
     * @return
     */
    private String getSizeString() {
        switch (sizeChoice) {
            case 1:
                return "Small";
            case 2:
                return "Medium";
            case 3:
                return "Large";

        }
    }
}
