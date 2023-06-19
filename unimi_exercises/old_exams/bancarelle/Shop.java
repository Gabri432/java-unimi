package unimi_exercises.old_exams.bancarelle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Mutable class representing the shop. A shop has a owner, an inventory and a list. 
 */
public class Shop {
    final public String owner;
    private Inventory inventory;
    

    /**
     * It constructs a Shop class object given its owner.
     * @param owner a String representing the owner of the Shop.
     * @throws NullPointerException if owner is null.
     * @throws IllegalArgumentException if owner is not at least 1 character long.
     */
    Shop(String owner) {
        Objects.requireNonNull("Shop owner cannot be null.");
        if (owner.trim().length() < 1) throw new IllegalArgumentException("Owner must be at least one character long.");
        this.owner = owner;
        //this.inventory = new Inventory();
    }

    class Inventory {
        private Map<Toy, Integer> inventory;
        
        /**
         * It constructs a new Inventory class object.
         */
        Inventory() {
            this.inventory = new HashMap<>();
        }

        /**
         * Adds a toy to the inventory.
         * @param toy the Toy object to add.
         * @throws NullPointerException if the Toy object is null.
         */
        public void addToy(Toy toy) {
            Objects.requireNonNull("Toy cannot be null.");
            if (inventory.containsKey(toy)) {
                inventory.put(toy, inventory.get(toy)+1);
            } else {
                inventory.putIfAbsent(toy, 1);
            }
        }

        /**
         * Removes a toy from the inventory, if found.
         * @param toy the Toy object to remove.
         * @throws NullPointerException if the Toy object is null.
         */
        public void removeToy(Toy toy) {
            Objects.requireNonNull("Toy cannot be null.");
            if (inventory.containsKey(toy)) {
                if (inventory.get(toy) == 1) {
                    inventory.remove(toy);
                } else {
                    inventory.put(toy, inventory.get(toy)-1);
                }
            }
        }

        /**
         * Returns true if toy is in the inventory, false otherwise.
         * @param toy the Toy class object to find in the inventory.
         * @return true if toy is in the inventory, false otherwise.
         * @throws NullPointerException if toy is null.
         */
        public boolean isInInventory(Toy toy) {
            Objects.requireNonNull("Toy cannot be null");
            if (inventory.get(toy).equals(null)) return false;
            return true;
        }

        @Override
        public String toString() {
            final StringBuilder s = new StringBuilder();
            for (var toyObj : inventory.entrySet()) {
                s.append(toyObj.getValue() + " " + toyObj.getKey().name  + " of " + toyObj.getKey().material + "\n");
            }
            return "";
        }
    }

    /**
     * Returns the price of the toy.
     * @param toy the Toy object to which find the price.
     * @return a float representing the price of the object.
     * @throws NullPointerException if toy is null.
     * @throws IllegalArgumentException if toy was not found in the inventory. 
     */
    public float price(Toy toy) {
        Objects.requireNonNull("Toy cannot be null.");
        if (!inventory.isInInventory(toy)) throw new IllegalArgumentException("No "+ toy + " was found.");
        return 0;
    }

    @Override
    public String toString() {
        return owner+"\'s shop \n" + inventory;
    }
    
}
