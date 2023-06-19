package unimi_exercises.old_exams.bancarelle;

public interface PriceList {
    /**
     * It calculates the total price for a purchase given a Toy, its quantity and an eventual discount.
     * @param toy the Toy class object from which start calculating the price.
     * @param quantity an Integer representing the quantity of toy to purchase.
     * @param discount an Integer from 0 to 99 representing the discount.
     * @return a float representing the total price of the purchase.
     * @throws NullPointerException if the toy is null.
     * @throws IllegalArgumentException if quantity is non-positive or discount is lower than 0 or higher than 99.
     */
    public float totalPrice(Toy toy, int quantity, int discount);
}
