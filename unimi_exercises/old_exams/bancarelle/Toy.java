package unimi_exercises.old_exams.bancarelle;

import java.util.Objects;

/**
 * Immutable class representing a toy given by its name, material and price.
 */
public class Toy {
    final public String name;
    final public String material;
    final public float price;

    //RI: name and material must be non-null and non-empty strings. Price must be at least 0.01.
    //AF: a toy is represented by three properties: name, material and price.

    /**
     * It constructs a Toy object given its name and material.
     * @param name a String representing the name of the toy.
     * @param material a String representing the material of the toy.
     * @throws NullPointerException if either toy name or toy material is null.
     * @throws IllegalArgumentException if either toy name or toy material is less than 1 character long or the price is lower than 0.01.
     */
    public Toy(String name, String material, float price) {
        Objects.requireNonNull(name, "Toy name cannot be null");
        Objects.requireNonNull(material, "Toy material cannot be null");
        if (name.trim().length() < 1) throw new IllegalArgumentException("Toy name must contain at least one character.");
        if (material.trim().length() < 1) throw new IllegalArgumentException("Toy material must contain at least one character.");
        if (price < 0.01) throw new IllegalArgumentException("Toy price must be at least 0.01.");
        this.name = name;
        this.material = material;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Toy)) {
            return false;
        }
        Toy toy = (Toy) obj;
        if (toy.name != this.name) return false;
        if (toy.material != this.material) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, material);
    }

    @Override
    public String toString() {
        return name + " di " + material;
    }
}
