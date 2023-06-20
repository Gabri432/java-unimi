package unimi_exercises.old_exams.bancarelle;

import java.util.Map;
import java.util.Objects;


/**
 * Immutable class representing a purchase given the purchased toy, the purchased quantity, the total price, and
 * the purchases of that toy per shop.
 */
public class Purchase {
    public final Toy toy;
    public final int quantity;
    public final float price;
    public final Map<Shop, Integer> purchasesPerShop;

    //RI: toy and purchasesPerShop (and any of its keys) must be non-null, quantity and price must be positive.
    //AF: A Purchase class object has 4 properties, toy, quantity, price and purchasePerShop.
    //purchasePerShop is a map that associates a shop with an integer. 
    //This property represents the quantity of a toy that has been purchased from that shop.

    /**
     * It constructs a Purchase class object given by the purchased toy, the purchased quantity, the total price, and
     * the purchases of that toy per shop.
     * @param toy the Toy class object the purchase is referring to.
     * @param quantity an Integer representing the purchased quantity of that toy.
     * @param price a float representing the total price of the purchases for that toy.
     * @param purchasesPerShop a Map<Shop, Integer> where the key representes a shop, meanwhile the Integer representes
     * the quantity of that toy that has been purchased from that shop.
     * @throws NullPointerException if either toy or purchasesPerShop is null, or a shop from the purchasesPerShop map is null.
     * @throws IllegalArgumentException if either price or quantity is non positive (respectevely price < 0.01 or quantity < 1).
     */
    public Purchase(Toy toy, int quantity, float price, Map<Shop, Integer> purchasesPerShop) {
        Objects.requireNonNull(toy,  "Toy cannot be null.");
        Objects.requireNonNull(purchasesPerShop, "The purchases per shop cannot be null.");
        if (price < 0.01) throw new IllegalArgumentException("null");
        if (quantity < 1) throw new IllegalArgumentException("null");
        for (var purchaseInShop : purchasesPerShop.entrySet()) {
            Objects.requireNonNull(purchaseInShop.getKey(), "A shop cannot be null.");
        }
        this.toy = toy;
        this.quantity = quantity;
        this.price = price;
        this.purchasesPerShop = purchasesPerShop;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Purchase of: "+ toy + ", for a price of:" + price +", quantity: "+ quantity + ", specifically:\n");
        for (var purchase : purchasesPerShop.entrySet()) {
            s.append(purchase.getValue() + " from " + purchase.getKey().owner + "\n");
        }
        return super.toString();
    }
}
