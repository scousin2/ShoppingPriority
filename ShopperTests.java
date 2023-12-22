package ShoppingPriority;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


 class ShopperTests {

	    @Test
	    void testAddShoppersAndCheckNotNullQueue() {
	        CustomPriorityQueue priorityQueueManager = new CustomPriorityQueue();

	        Shopper shopper1 = new Shopper("Shopper1", 10, 80.0);
	        Shopper shopper2 = new Shopper("Shopper2", 15, 120.0);
	        Shopper shopper3 = new Shopper("Shopper3", 12, 90.0);
	        Shopper shopper4 = new Shopper("Shopper4", 9, 102.0);

	        // Add shoppers to the priority queue
	        priorityQueueManager.enqueue(shopper1);
	        priorityQueueManager.enqueue(shopper2);
	        priorityQueueManager.enqueue(shopper3);
	        priorityQueueManager.enqueue(shopper4);

	        // Ensure shoppers are added to the priority queue
	       //assertNotNull(priorityQueueManager);
	       //assertFalse(priorityQueueManager.isEmpty());

	        // Additional assertions based on your requirements
	        assertEquals(shopper2, priorityQueueManager.dequeue());
	        //assertEquals(shopper3, priorityQueueManager.dequeue());
	       // assertEquals(shopper4, priorityQueueManager.dequeue());
	       // assertEquals(shopper1, priorityQueueManager.dequeue());

	        //assertTrue(priorityQueueManager.isEmpty());
	    }
	

		 @Test
		    void testAddShoppersAndCheckout() {
		        CustomPriorityQueue priorityQueueManager = new CustomPriorityQueue();

		        Shopper shopper1 = new Shopper("Shopper1", 10, 80.0);
		        Shopper shopper2 = new Shopper("Shopper2", 15, 120.0);
		        Shopper shopper3 = new Shopper("Shopper3", 12, 90.0);
		        Shopper shopper4 = new Shopper("Shopper4", 9, 102.0);

		        // Add shoppers to the priority queue
		        priorityQueueManager.enqueue(shopper1);
		        priorityQueueManager.enqueue(shopper2);
		        priorityQueueManager.enqueue(shopper3);
		        priorityQueueManager.enqueue(shopper4);

		       
		        // Ensure shoppers are added to the priority queue
		        assertEquals(shopper2, priorityQueueManager.dequeue());
		    }



		 
		    @Test
		    void testCouponDistributionAndCheckout() {
		    	CustomPriorityQueue priorityQueueManager = new CustomPriorityQueue();
		    	CustomPriorityQueue priorityQueueManagerForCoupon = new CustomPriorityQueue();

		        Shopper shopper1 = new Shopper("Shopper1", 10, 80.0);
		        Shopper shopper2 = new Shopper("Shopper2", 15, 120.0);
		        Shopper shopper3 = new Shopper("Shopper3", 12, 90.0);
		        Shopper shopper4 = new Shopper("Shopper4", 9, 102.0);

		        // Add shoppers to the priority queue
		        priorityQueueManager.enqueue(shopper1);
		        priorityQueueManager.enqueue(shopper2);
		        priorityQueueManager.enqueue(shopper3);
		        priorityQueueManager.enqueue(shopper4);

		        // Simulate checkout process after coupon
		        ShoppingSystem ss = new ShoppingSystem();
		        priorityQueueManager = ss.addToQueueWithAdjustedCoupon(priorityQueueManager, priorityQueueManagerForCoupon);

		        // Ensure shoppers receive coupons based on the specified conditions
		        assertEquals(shopper2, priorityQueueManager.dequeue());
		        assertEquals(105.0, shopper2.getTotalPurchase(), 0.001);
		        
		        assertEquals(shopper3, priorityQueueManager.dequeue());
		        assertEquals(90.0, shopper3.getTotalPurchase(), 0.001);
		    }
		    
		    @Test
		    void testStabilityOfPriorityQueue() {
		    	CustomPriorityQueue priorityQueueManager = new CustomPriorityQueue();
		    	CustomPriorityQueue priorityQueueManagerForCoupon = new CustomPriorityQueue();

		        Shopper shopper1 = new Shopper("Shopper1", 10, 90.0);
		        Shopper shopper2 = new Shopper("Shopper2", 15, 120.0);
		        Shopper shopper3 = new Shopper("Shopper3", 12, 90.0);
		        Shopper shopper4 = new Shopper("Shopper4", 9, 19.0);

		        // Add shoppers to the priority queue
		        priorityQueueManager.enqueue(shopper1);
		        priorityQueueManager.enqueue(shopper2);
		        priorityQueueManager.enqueue(shopper3);
		        priorityQueueManager.enqueue(shopper4);

		        // Simulate checkout process after coupon
		        ShoppingSystem ss = new ShoppingSystem();
		        priorityQueueManager = ss.addToQueueWithAdjustedCoupon(priorityQueueManager, priorityQueueManagerForCoupon);

		        // Ensure shopper1 is dequeued right before shopper3
		        priorityQueueManager.dequeue();
		        assertEquals(shopper1, priorityQueueManager.dequeue());
		        assertEquals(shopper3, priorityQueueManager.dequeue());
		        
		    }
	}
}

	/*@Test
    void checkoutTest() {
        // Create shoppers with different purchase values
        Shopper shopper1 = new Shopper("Alice", 3, 50.0);
        Shopper shopper2 = new Shopper("Bob", 2, 100.0);
        Shopper shopper3 = new Shopper("Charlie", 5, 75.0);

        // Create a priority queue and enqueue shoppers
        CustomPriorityQueue shopperQueue = new CustomPriorityQueue();
        shopperQueue.enqueue(shopper1);
        shopperQueue.enqueue(shopper2);
        shopperQueue.enqueue(shopper3);

        // Redirect System.out for assertions
        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       // PrintStream originalOut = System.out;
       // try {
         //   System.setOut(new PrintStream(outputStream));

            // Perform the checkout
          //  CheckoutProcessor.checkout(shopperQueue);
       // } finally {
       //     System.setOut(originalOut);
        }

        // Define the expected checkout order based on purchase values
        String expectedCheckoutOrder = "Checking out (1): Bob\n" +
                                       "Checking out (2): Charlie\n" +
                                       "Checking out (3): Alice";

        assertEquals((Bob, Charlie, Alic),expectedCheckoutOrder())

}*/
