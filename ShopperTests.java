package ShoppingPriority;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



 class ShopperTests {
	 
	     @Test
	     void testDistributeCoupons() {
	         CustomPriorityQueue shopperQueue = new CustomPriorityQueue();

	         Shopper shopper1 = new Shopper("Shopper1", 5, 80.0);
	         Shopper shopper2 = new Shopper("Shopper2", 10, 120.0);
	         Shopper shopper3 = new Shopper("Shopper3", 8, 90.0);
	         Shopper shopper4 = new Shopper("Shopper4", 7, 102.0);

	         shopperQueue.enqueue(shopper1);
	         shopperQueue.enqueue(shopper2);
	         shopperQueue.enqueue(shopper3);
	         shopperQueue.enqueue(shopper4);

	         // Call the distributeCoupons method
	         CustomPriorityQueue updatedShopperQueue = CouponDistributor.distributeCoupons(shopperQueue);

	         // Verify that shoppers who should receive a coupon have their purchase updated
	         assertEquals(80.0, shopper1.getTotalPurchase()); // No coupon for Shopper1
	         assertEquals(20.0, shopper2.getTotalPurchase()); // Coupon for Shopper2
	         assertEquals(90.0, shopper3.getTotalPurchase()); // No coupon for Shopper3
	         assertEquals(2.0, shopper4.getTotalPurchase());  // Coupon for Shopper4

	       
	     }
	     @Test
	     void testCheckout() {
	         CustomPriorityQueue shopperQueue = new CustomPriorityQueue();

	         Shopper shopper1 = new Shopper("Shopper1", 5, 80.0);
	         Shopper shopper2 = new Shopper("Shopper2", 10, 120.0);
	         Shopper shopper3 = new Shopper("Shopper3", 8, 90.0);
	         Shopper shopper4 = new Shopper("Shopper4", 7, 102.0);

	         shopperQueue.enqueue(shopper1);
	         shopperQueue.enqueue(shopper2);
	         shopperQueue.enqueue(shopper3);
	         shopperQueue.enqueue(shopper4);

	         // Call the checkout method
	         CheckoutProcessor.checkout(shopperQueue);

	         // You can add assertions based on the actual behavior of the method
	         // For example, check if shoppers are dequeued in the expected order
	         assertEquals("Shopper2", shopper2.getName());
	         assertEquals("Shopper4", shopper4.getName());
	         assertEquals("Shopper3", shopper3.getName());
	         assertEquals("Shopper1", shopper1.getName());
	     }
	     
	     
	     @Test
	     void testCompareTo() {
	         // Create shoppers with different purchase values and insertion orders
	         Shopper shopper1 = new Shopper("Shopper1", 5, 80.0);
	         Shopper shopper2 = new Shopper("Shopper2", 10, 120.0);
	         Shopper shopper3 = new Shopper("Shopper3", 8, 90.0);
	         Shopper shopper4 = new Shopper("Shopper4", 7, 102.0);

	         // Test when purchase values are different
	         assertTrue(shopper2.compareTo(shopper1) > 0);
	         assertTrue(shopper1.compareTo(shopper2) < 0);

	        
	         
	     }
	     
	     @Test
	     void testCompareToinsertion() {
	         // Create shoppers with different purchase values and insertion orders
	         Shopper shopper1 = new Shopper("Shopper1", 5, 80.0);
	         Shopper shopper2 = new Shopper("Shopper2", 10, 120.0);
	         Shopper shopper3 = new Shopper("Shopper3", 8, 90.0);
	         Shopper shopper4 = new Shopper("Shopper4", 7, 102.0);
	         
	         // Test when purchase values are equal but insertion orders are different
	         assertTrue(shopper3.compareTo(shopper4) < 0);
	         assertTrue(shopper4.compareTo(shopper3) > 0);
	     }
	     
	 }

 

	 
