package unimi_exercises.old_exams.bancarelle;

import java.util.Objects;

/**
 * Immutable class representing a toy given by its name and material.
 */
public class Toy {
    final public String name;
    final public String material;

    //RI: name and material must be non-null and non-empty strings.
    //AF: a toy is represented by two properties, name and material.

    /**
     * It constructs a Toy object given its name and material.
     * @param name a String representing the name of the toy.
     * @param material a String representing the material of the toy.
     * @throws NullPointerException if either toy name or toy material is null.
     * @throws IllegalArgumentException if either toy name or toy material is less than 1 character long.
     */
    Toy(String name, String material) {
        Objects.requireNonNull(name, "Toy name cannot be null");
        Objects.requireNonNull(material, "Toy material cannot be null");
        if (name.trim().length() < 1) throw new IllegalArgumentException("Toy name must contain at least one character.");
        if (material.trim().length() < 1) throw new IllegalArgumentException("Toy material must contain at least one character.");
        this.name = name;
        this.material = material;
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
