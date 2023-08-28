package random_programs;

import java.util.Objects;

/**
 * A class offering a series of methods to keep track of the items in the fridge.
 */
public class Fridge {

    /**
     * A class representing any item that could be stored in a fridge.
     */
    public class FridgeItem {
        private final String name;
        private final String expireDate; //in format day-month-year
        private int quantity; 

        //RI: quantity >= 0; name and expireDate must be not null or empty strings;

        /**
         * Creates a new FridgeItem instance given its name, expireDate and quantity.
         * @param name a string representing the name of the item.
         * @param expireDate a string in the format dd-mm-yyyy representing the expiration date.
         * @param quantity a non-negative integer representing the quantity of the item.
         * @throws NullPointerException if either name or expireDate are null strings.
         * @throws IllegalArgumentException if either name or expireDate are empty strings, or if the quantity is negative, 
         * or if the expireDate is wrong. That is: day not in range 1-31 or month not in range 1-12.
         */
        public FridgeItem(String name, String expireDate, int quantity) {
            if (Objects.requireNonNull(name, "Name must be defined.").isEmpty()) 
                throw new IllegalArgumentException("Name cannot be an empty string");
            if (Objects.requireNonNull(expireDate, "Name must be defined.").isEmpty()) 
                throw new IllegalArgumentException("Name cannot be an empty string");
            if (quantity < 0) 
                throw new IllegalArgumentException("Quantity must be a non-negative integer.");

            String[] DMY = expireDate.split("-"); //Assuming the date is always in this format: dd-mm-yyyy
            int day = Integer.parseInt(DMY[0]);
            int month = Integer.parseInt(DMY[1]);
            if (day > 31 || day < 1) throw new IllegalArgumentException("Non valid day value.");
            if (month > 12 || month < 1) throw new IllegalArgumentException("Non valid month value.");

            this.name = name;
            this.expireDate = expireDate;
            this.quantity = quantity;
        }

        public String getName() {
            return this.name;
        }

        public String getExpireDate() {
            return this.expireDate;
        }

        public int getQuantity() {
            return this.quantity;
        }
    }
    
}
