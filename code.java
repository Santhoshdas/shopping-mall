import java.util.*;

class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ShoppingMall {

    static Map<Integer, List<Item>> floorItems = new HashMap<>();
    static List<Item> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> floor1 = new ArrayList<>();

        floor1.add(new Item("Sofa", 15000.0));
        floor1.add(new Item("Chair", 3000.0));
        floor1.add(new Item("Table", 5000.0));
        floor1.add(new Item("Bed", 18000.0));

        List<Item> floor2 = new ArrayList<>();
        floor2.add(new Item("Apple (1kg)", 150.0));
        floor2.add(new Item("Carrot (1kg)", 60.0));
        floor2.add(new Item("Tomato (1kg)", 40.0));
        floor2.add(new Item("Banana (1 dozen)", 100.0));

        List<Item> floor3 = new ArrayList<>();
        floor3.add(new Item("Saree", 2500.0));
        floor3.add(new Item("Kurti", 800.0));
        floor3.add(new Item("T-Shirt", 600.0));
        floor3.add(new Item("Jeans", 1200.0));

        List<Item> floor4 = new ArrayList<>();
        floor4.add(new Item("Flip-flop", 300.0));
        floor4.add(new Item("Casual Sandals", 500.0));
        floor4.add(new Item("Formal Slippers", 700.0));
        floor4.add(new Item("Home Slippers", 250.0));

        floorItems.put(1, floor1);
        floorItems.put(2, floor2);
        floorItems.put(3, floor3);
        floorItems.put(4, floor4);

        int choice;
        do {
            System.out.println("\n=== Welcome to the Multi-Floor Shopping Mall ===");
            System.out.println("1. Go to a Floor to Shop");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout & Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        goToFloor(scanner);
                        break;
                    case 2:
                        viewCart();
                        break;
                    case 3:
                        checkout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose from 1 to 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                choice = 0;
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void goToFloor(Scanner scanner) {
        System.out.println("\n--- Select a Floor ---");
        System.out.println("1. Furniture");
        System.out.println("2. Fruits and Vegetables");
        System.out.println("3. Dresses (Men & Women)");
        System.out.println("4. Slippers");
        System.out.print("Enter floor number (1-4): ");

        if (scanner.hasNextInt()) {
            int floor = scanner.nextInt();
            if (floorItems.containsKey(floor)) {
                List<Item> items = floorItems.get(floor);
                displayItems(items);

                System.out.print("Enter item number to add to cart (or 0 to cancel): ");
                if (scanner.hasNextInt()) {
                    int itemChoice = scanner.nextInt();
                    if (itemChoice > 0 && itemChoice <= items.size()) {
                        Item selectedItem = items.get(itemChoice - 1);
                        cart.add(selectedItem);
                        System.out.println(selectedItem.name + " added to cart.");
                    } else if (itemChoice == 0) {
                        System.out.println("Returning to main menu.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else {
                System.out.println("Invalid floor number.");
            }
        } else {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    public static void displayItems(List<Item> items) {
        System.out.println("\nAvailable Items:");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d. %s - ₹%.2f\n", i + 1, item.name, item.price);
        }
    }

    public static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\nItems in your cart:");
        double total = 0.0;
        for (Item item : cart) {
            System.out.printf("- %s: ₹%.2f\n", item.name, item.price);
            total += item.price;
        }
        System.out.printf("Total Price: ₹%.2f\n", total);
    }

    public static void checkout() {
        System.out.println("\n=== Checkout ===");
        viewCart();
        System.out.println("Thank you for shopping with us!");
    }
}
shopping mall
