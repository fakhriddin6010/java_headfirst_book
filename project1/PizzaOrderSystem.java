public static void main(String[] args) {
    ArrayList<PizzaOrderApp> order = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // loop to allow the customer to select pizzas and sizes
    boolean ordering = true;
    while(ordering) {
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
    for(PizzaOrderApp pizza : order) {
        System.out.println(pizza.getQuantity() + " " + pizza.getSize() + " " + pizza.getType() + " $" + pizza.getPrice());
        total += pizza.getPrice();
    }
    System.out.println("Total: $" + total);

    // ask for payment method
    System.out.println("Please select a payment method:");
    System.out.println("1. Cash");
    System.out.println("2. Credit Card");

    // get user input for payment method
    int paymentSelection = scanner.nextInt();

    // handle cash payment
    if (paymentSelection == 1) {
        System.out.println("Thank you for your payment!");
        System.out.println("Cash payment summary:");
        System.out.println("Total: $" + total);
        System.out.println("Amount paid: $");
        double amountPaid = scanner.nextDouble();
        System.out.println("Change: $" + (amountPaid - total));
    }

    // handle credit card payment
    else if (paymentSelection == 2) {
        System.out.println("Please enter cardholder name:");
        String cardholderName = scanner.next();
