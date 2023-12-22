package ShoppingPriority;

/*
 * The CouponDistributor class distributes coupons to eligible shoppers.
 * It dequeues shoppers from the priority queue, checks their total purchase value,
 * and updates their total purchase accordingly. Shoppers with a total purchase above $100
 * are eligible.
 */
public class CouponDistributor {

    public static CustomPriorityQueue distributeCoupons(CustomPriorityQueue shopperQueue) {
        System.out.println("\nCoupon Distribution:");

        CustomPriorityQueue updatedShopperQueue = new CustomPriorityQueue();
        //go through the queue, if purchase total is over 100$, they receive the coupon
        while (!shopperQueue.isEmpty()) {
            Shopper shopper = shopperQueue.dequeue();
            if (shopper.getTotalPurchase() > 100.0) {
                System.out.println(shopper.getName() + " receives a coupon!");
                // Subtract the coupon value
                shopper.updateTotalPurchase(-100.0); 
            }
            updatedShopperQueue.enqueue(shopper);
        }

        return updatedShopperQueue;
    }
}
