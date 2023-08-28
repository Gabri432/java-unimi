package random_programs;

import java.util.Objects;

import random_programs.CommandLine.Command;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * A class offering a series of methods to keep track of the items in the fridge. <br /><br />
 * A fridge contains a map item:quantity.
 */
public class Fridge {
    private Map<FridgeItem, Integer> fridge = new HashMap<>();
    /**
     * A class representing any item that could be stored in a fridge.
     */
    public class FridgeItem {
        private final String name;
        private final String expireDate; //in format day-month-year

        //RI: name and expireDate must be not null or empty strings;

        /**
         * Creates a new FridgeItem instance given its name, expireDate and quantity.
         * @param name a string representing the name of the item.
         * @param expireDate a string in the format dd-mm-yyyy representing the expiration date.
         * @throws NullPointerException if either name or expireDate are null strings.
         * @throws IllegalArgumentException if either name or expireDate are empty strings, 
         * or if the expireDate is wrong. That is: day not in range 1-31 or month not in range 1-12.
         */
        public FridgeItem(String name, String expireDate) {
            if (Objects.requireNonNull(name, "Name must be defined.").isEmpty()) 
                throw new IllegalArgumentException("Name cannot be an empty string");
            if (Objects.requireNonNull(expireDate, "Name must be defined.").isEmpty()) 
                throw new IllegalArgumentException("Name cannot be an empty string");

            String[] DMY = expireDate.split("-"); //Assuming the date is always in this format: dd-mm-yyyy
            int day = Integer.parseInt(DMY[0]);
            int month = Integer.parseInt(DMY[1]);
            if (day > 31 || day < 1) throw new IllegalArgumentException("Non valid day value.");
            if (month > 12 || month < 1) throw new IllegalArgumentException("Non valid month value.");

            this.name = name;
            this.expireDate = expireDate;
        }

        public String getName() {
            return this.name;
        }

        public String getExpireDate() {
            return this.expireDate;
        }

        /**
         * Verifies if the item has expired, that is, if the expiration date has already passed. 
         * @return true if the expiration date has passed, false otherwise.
         */
        public boolean isExpired() {
            LocalDate today = LocalDate.now();
            String[] DMY = this.expireDate.split("-"); 
            int year = Integer.parseInt(DMY[2]);
            int month = Integer.parseInt(DMY[1]);
            int day = Integer.parseInt(DMY[0]);
            return LocalDate.of(year, month, day).isAfter(today);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof FridgeItem)) {
                return false;
            }

            FridgeItem item = (FridgeItem) obj;
            if (!(item.name.equals(getName()))) return false; //Comparing names.
            if (!(item.expireDate.equals(getExpireDate()))) return false; //Comparing expiration dates.
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getExpireDate());
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(name);
            s.append(" will expire in date: ");
            s.append(expireDate);
            return s.toString();
        }
    }

    /**
     * Adds a new item to the fridge.
     * @param name a string representing the name of the item.
     * @param expireDate a string in the format dd-mm-yyyy representing the expiration date of the item.
     * @param quantity a non-negative integer representing the quantity of that item.
     * @throws NullPointerException if either name or expireDate are null strings.
     * @throws IllegalArgumentException if either name or expireDate are empty strings, or if the quantity is negative, 
     * or if the expireDate is wrong. That is: day not in range 1-31 or month not in range 1-12.
     */
    public void addItem(String name, String expireDate, int quantity) {
        Fridge.FridgeItem newItem = new FridgeItem(name, expireDate);
        if (fridge.containsKey(newItem)) {
            fridge.replace(newItem, quantity);
        }
        fridge.putIfAbsent(newItem, quantity);
    }

    /**
     * Removes a certain quantity of an item to the fridge.
     * @param name a string representing the name of the item.
     * @param expireDate a string in the format dd-mm-yyyy representing the expiration date of the item.
     * @param quantity a non-negative integer representing the quantity of that item.
     * @throws NullPointerException if either name or expireDate are null strings.
     * @throws IllegalArgumentException if either name or expireDate are empty strings, or if the quantity is negative, 
     * or if the expireDate is wrong. That is: day not in range 1-31 or month not in range 1-12.
     */
    public void removeItem(String name, String expireDate, int quantity) {
        Fridge.FridgeItem newItem = new FridgeItem(name, expireDate);
        if (fridge.containsKey(newItem)) {
            int oldQuantity = fridge.get(newItem);
            if (oldQuantity <= quantity) {
                fridge.replace(newItem, 0);
            } else {
                fridge.replace(newItem, oldQuantity - quantity);
            }
        }
    }

    public void listItems() {
        System.out.println("All items: ");
        System.out.println(fridge);
    }

    public void listExpiredItems() {
        System.out.println("Expired items:");
        for (Fridge.FridgeItem item : fridge.keySet()) {
            if (item.isExpired()) {
                System.out.println(item);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Fridge.FridgeItem item : fridge.keySet()) {
            s.append("Item: ");
            s.append(item);
            s.append(", Quantity: ");
            s.append(fridge.get(item));
            s.append("\n");
        }
        return s.toString();
    }
    
}
