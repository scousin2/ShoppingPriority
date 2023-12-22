package ShoppingPriority;

/*
 * The CheckoutProcessor class  is the checkout process in an online shopping system.
 * It dequeues shoppers from the priority queue and prints their names in the checkout order.
 */
public class CheckoutProcessor {
	//the checkout process dequeues shoppers and prints their names in the checkout order.
    public static void checkout(CustomPriorityQueue shopperQueue) {
        System.out.println("\nCheckout Process:");
        int checkoutOrder = 1;

        //temporary queue to store shoppers for checkout
        CustomPriorityQueue checkoutQueue = new CustomPriorityQueue();
        //as long as there's still a line, keep removing.
        while (!shopperQueue.isEmpty()) {
            Shopper shopper = shopperQueue.dequeue();
            checkoutQueue.enqueue(shopper);
        }

        while (!checkoutQueue.isEmpty()) {
            Shopper shopper = checkoutQueue.dequeue();
            System.out.println("Checking out (" + checkoutOrder + "): " + shopper.getName());
            checkoutOrder++;
        }
    }
}
