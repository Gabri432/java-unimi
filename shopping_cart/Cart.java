package shopping_cart;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A cart represent a list of products.
 * Cart is a mutable concrete class, because products can be added and removed from it.
 */
public class Cart {
    private Map<Product, Integer> cart = new HashMap<>();
    //Abstraction Function: a cart represents a map where each key is a product and each value is the quantity of that product.
    //Representation Invariant: The product list cannot be null or contain null product name.

    /**
     * Creates a new empty cart.
     */
    public Cart() {}

    /**
     * Builds a cart starting from a map in which each product is associated to its quantity.
     * @param cart a product-quantity map.
     * @throws NullPointerException if the map is null.
     * @throws IllegalArgumentException if the map contains a null product.
     */
    public Cart(Map<Product, Integer> cart) {
        Objects.requireNonNull(cart, "The list cannot be null.");
        for (Map.Entry<Product, Integer> e: cart.entrySet())
            add(e.getValue(), e.getKey());
    }

    /**
    * Builds a copy of the cart.
    *
    * @param original the car to copy.
    * @throws NullPointerException if the cart is null.
    */
    public Cart(final Cart original) {
       this(original.cart);
    }

    /**
     * Adds a product to the cart.
     * @param quantity the integer representing the amount of that product to add.
     * @param product the product to add to the cart.
     * @throws NullPoiniterException if the product is null.
     * @throws IllegalArgumentException if the quantity is non-positive.
     */
    public void add(final int quantity, final Product product) {
        Objects.requireNonNull(product, "The product cannot be null.");
        if (quantity < 1) throw new IllegalArgumentException("The quantity must be a positive integer.");
        cart.put(product, quantity); 
    }

    /**
     * Adds a product to the cart.
     * @param product the product to add to the cart.
     * @throws NullPoiniterException if the product is null.
     */
    public void add(Product product) {
        add(1, product);
    }

    /**
     * Removes a certain quantity of a product from the cart. If the quantity to remove is greater 
     * than the existing quantity in the cart it will simply remove all the instances of that product. 
     * @param quantity the integer representing the quantity of the product to remove. 
     * @param product the product which a certain quantity is to be removed.
     * @throws NullPointerException if the product is null.
     * @throws IllegalArgumentException if the quantity is non-positive.
     * @throws NoSuchElementException if the product was not in the cart.
     */
    public void remove(final int quantity, final Product product) {
        Objects.requireNonNull(product, "The product cannot be null.");
        if (quantity < 1) throw new IllegalArgumentException("The quantity cannot be non-positive.");
        if (!cart.containsKey(product)) throw new NoSuchElementException("Cannot find the product "+ product);
        if (cart.get(product) - quantity <= 0) {
            cart.remove(product);
        } else {
            cart.put(product, cart.get(product) - quantity);
        }
    }

    /**
     * Get the product from the cart.
     * @param product the product to get.
     * @return the product, if it is found.
     * @throws NullPointerException if the product is null.
     * @throws NoSuchElementException if the product was not in the cart.
     */
    public Product getProduct(Product product) {
        Objects.requireNonNull(product);
        if (!cart.containsKey(product)) throw new NoSuchElementException("Cannot find the product "+ product);
        for (Map.Entry<Product, Integer> e: cart.entrySet()) {
            if (e.getKey().equals(product)) return e.getKey();
        }
        throw new NoSuchElementException("No product "+product.name +" with price "+ product.price + "was found");
    }

    @Override
    public String toString() {
      final StringBuilder result = new StringBuilder();
      for (final Product p : cart.keySet()) result.append(p + ", quantity: "+ cart.get(p) +"\n");
      return result.toString();
    }
}
