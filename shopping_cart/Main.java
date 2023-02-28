package shopping_cart;

import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        System.out.println("Running.");
        Scanner input = new Scanner(System.in);
        Cart cart = new Cart();
        float budget = 0;
        float cost = 0;
        int totalQuantity = 0;
        while (input.hasNextLine()) {
            String data = input.nextLine();
            if (data.equals("EXIT"))
                break;
            if (data.equals("TOTAL")) {
                System.out.println("TOTAL = " + cost + ", REST = " + (budget-cost) + ", QUANTITY = " + totalQuantity);
                continue;
            }
            if (data.contains("REMOVE")) {
                String[] prdData = (data.split(":"))[1].split(",");
                Product prd = formatProduct(prdData[0],prdData[1]);
                int quantity = Integer.parseInt(prdData[2].trim());
                cart.remove(quantity, prd);
                cost -= prd.price;
                quantity -= 1;
                System.out.println(cart);
                continue;
            }
            if (!data.contains(",") && budget == 0) {
                budget = Float.parseFloat(data);
            } else {
                String[] prdData = data.split(",");
                Product prd = formatProduct(prdData[0],prdData[1]);
                int quantity = Integer.parseInt(prdData[2].trim());
                cost += prd.price*quantity;
                totalQuantity += quantity;
                cart.add(quantity, prd);
            }
        }
        input.close();
        System.out.println(cart);
    }  
    
    public static Product formatProduct(String prdName, String prdPrice) {
        float price = Float.parseFloat(prdPrice.trim());
        return new Product(prdName.trim(), price);
    }
}
