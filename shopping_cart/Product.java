package shopping_cart;

import java.util.Objects;

/**
 * A product is an object defined by its name and price.
 * Product is an immutable concrete class that represents a product.
 */
public class Product {
    public final String name;
    public final float price;

    //Abstraction function: represents the product as an object with name and price attributes.
    //Representation Invariant: name cannot be a null string and the price must be a positive float.

    /**
     * It builds a product given its name and price.
     * @param name a non-null string defining the name of the product.
     * @param price a positive float defining the price of the product.
     * @throws NullPointerException if the name is a null string.
     * @throws IllegalArgumentException if the price is a non-positive float.
     */
    public Product(String name, float price) {
        this.name = Objects.requireNonNull(name, "The product name cannot be null.");
        if (price < 0.01) {
            throw new IllegalArgumentException("The product price cannot be non-positive.");
        }
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) return true;
        final Product prd = (Product) obj;
        return prd.name.equals(name) && prd.price == price;
    }

    @Override
    public String toString() {
        return "Name: "+ this.name + ", price: " + this.price;
    }
}
