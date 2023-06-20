package unimi_exercises.old_exams.bancarelle;

import java.util.Objects;
import java.util.Set;

/**
 * Immutable abstract class representing the buyer given by the set of shops to buy toys from.
 */
public abstract class Buyer {
    public final Set<Shop> shops;

    //RI: the set of shops cannot be null or contain a null element.
    //AF: representes a buyer based on the set shops to buy toys from.

    /**
     * It constructs a buyer given the set of shops to buy toys from.
     * @param shops a set of Shop class objects representing the list of shops to buy toys from.
     * @throws NullPointerException if shops is null or contains a null shop.
     */
    public Buyer(Set<Shop> shops) {
        Objects.requireNonNull(shops, "The shop set cannot be null.");
        for (var shop : shops) {
            Objects.requireNonNull(shop, "The shop set cannot contain a null shop.");
        }
        this.shops = shops;
    }
}
