package random_programs;

import java.util.Objects;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A class offering a series of methods to keep track of the items in the fridge. <br /><br />
 * A fridge contains a set of items.
 */
public class Fridge {
    private Set<FridgeItem> fridge = new HashSet<>();
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
    }
    
}
