package ShoppingPriority;

/*
 * The Shopper class represents a shopper in the online store.
 * Each shopper has a name, the number of items purchased, total purchase value,
 * and an insertion order to maintain stable sorting in the priority queue.
 */

public class Shopper implements Comparable<Shopper> {
    private static int totalShoppers = 0;

    private String name;
    private int itemsPurchased;
    private double totalPurchase;
    private int insertionOrder;

    public Shopper(String name, int itemsPurchased, double totalPurchase) {
        this.name = name;
        this.itemsPurchased = itemsPurchased;
        this.totalPurchase = totalPurchase;
        this.insertionOrder = totalShoppers++;
    }
    /*
     * Returns the name of the shopper.
     */
    public String getName() {
        return name;
    }
    /*
     * Returns the amount of items purchased.
     */
    public int getItemsPurchased() {
        return itemsPurchased;
    }
    /*
     * Returns the total purchase.
     */
    public double getTotalPurchase() {
        return totalPurchase;
    }
    /*
     * Returns the order in the way they entered.
     */
    public int getInsertionOrder() {
        return insertionOrder;
    }
    /*
     * Updates the purchase total if they received a coupon
     */
    public void updateTotalPurchase(double additionalPurchase) {
        this.totalPurchase += additionalPurchase;
    }
    /*
     * Compares total purchase price with the shoppers and returns it.
     * if they have the same total, whoever came first goes first.
     */
    @Override
    public int compareTo(Shopper other) {
        int purchaseComparison = Double.compare(this.totalPurchase, other.totalPurchase);
        if (purchaseComparison != 0) {
            return purchaseComparison;
        }
        // Compare based on insertion order if purchase values are equal
        return Integer.compare(this.insertionOrder, other.insertionOrder);
    }
}
