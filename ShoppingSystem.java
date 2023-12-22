package ShoppingPriority;

/*
 * The ShoppingSystem class simulates an online shopping system where shoppers can 
 * add items to their cart, receive coupons based on their total purchase value,
 *  and go through the checkout process.
 */
import java.util.Scanner;

public class ShoppingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomPriorityQueue shopperQueue = new CustomPriorityQueue();

        System.out.println("Welcome to the online Shopping System!");
        System.out.println("Please enter your detials as requested.");

        // Shoppers enter their information in this while loop.
        while (true) {
            System.out.print("Enter shopper name (or 'exit' to finish): ");
            String name = scanner.nextLine();
            //this will break out of the while loop
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter items purchased by " + name + ": ");
            int itemsPurchased = scanner.nextInt();

            System.out.print("Enter total purchase value by " + name + ": ");
            double totalPurchase = scanner.nextDouble();

            scanner.nextLine(); // 

            Shopper shopper = new Shopper(name, itemsPurchased, totalPurchase);
            shopperQueue.enqueue(shopper);
        }

        // call the coupon distribution class
        shopperQueue = CouponDistributor.distributeCoupons(shopperQueue);

        // call the checkout process class
        CheckoutProcessor.checkout(shopperQueue);
    }
}


