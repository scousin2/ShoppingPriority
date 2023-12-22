package ShoppingPriority;

/*
 * The CustomPriorityQueue class represents a priority queue implemented using an array-based heap.
 * It maintains shoppers in descending order based on their total purchase values.
 */
public class CustomPriorityQueue {
    private Shopper[] shoppers;
    private int size;
    // this will allow for up to 10 customers initially
    public CustomPriorityQueue() {
        this.shoppers = new Shopper[10]; 
        this.size = 0;
    }
    //adds the shopper to the queue
    public void enqueue(Shopper shopper) {
        if (size == shoppers.length) {
            // If the array is full, double its size
            Shopper[] newShoppers = new Shopper[shoppers.length * 2];
            System.arraycopy(shoppers, 0, newShoppers, 0, size);
            shoppers = newShoppers;
        }

        shoppers[size++] = shopper;
        // maintain the priority order 
        heapifyUp();
    }
    //removing the customer 
    public Shopper dequeue() {
    	//check if its empty
        if (isEmpty()) {
            return null;
        }
        Shopper highestPriorityShopper = shoppers[0];
        shoppers[0] = shoppers[--size];
        // maintain the priority order
        heapifyDown();
        return highestPriorityShopper;
    }
    //method for checking if there's shoppers left
    public boolean isEmpty() {
        return size == 0;
    }
    //maintain the heap property after adding an element.
    //checks the parent
    private void heapifyUp() {
        int index = size - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (shoppers[index].compareTo(shoppers[parentIndex]) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    //maintain the heap property after removing an element.
    // checks the children
    private void heapifyDown() {
        int index = 0;
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;

            if (leftChildIndex < size && shoppers[leftChildIndex].compareTo(shoppers[smallestChildIndex]) > 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && shoppers[rightChildIndex].compareTo(shoppers[smallestChildIndex]) > 0) {
                smallestChildIndex = rightChildIndex;
            }

            // Handle the case where shoppers have the same total purchase value
            if (smallestChildIndex != index && shoppers[smallestChildIndex].getTotalPurchase() == shoppers[index].getTotalPurchase()) {
                if (shoppers[smallestChildIndex].getInsertionOrder() < shoppers[index].getInsertionOrder()) {
                    swap(index, smallestChildIndex);
                    index = smallestChildIndex;
                } else {
                    break;
                }
            } else if (smallestChildIndex != index) {
                swap(index, smallestChildIndex);
                index = smallestChildIndex;
            } else {
                break;
            }
        }
    }
    //swapping method if priority changes
    private void swap(int i, int j) {
        Shopper temp = shoppers[i];
        shoppers[i] = shoppers[j];
        shoppers[j] = temp;
    }
}



