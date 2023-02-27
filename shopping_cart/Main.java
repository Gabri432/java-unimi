package shopping_cart;

import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        System.out.println("Running.");
        Scanner input = new Scanner(System.in);
        Cart cart = new Cart();
        float budget = 0;
        float cost = 0;
        while (input.hasNextLine()) {
            String data = input.nextLine();
            if (data.equals("EXIT"))
                break;
            if (!data.contains(",") && budget == 0) {
                budget = Float.parseFloat(data);
            } else {
                String[] prdData = data.split(",");
                String name = prdData[0];
                float price = Float.parseFloat(prdData[1].trim());
                int quantity = Integer.parseInt(prdData[2].trim());
                cost += price*quantity;
                cart.add(quantity, new Product(name, price));
            }
        }
        input.close();
        System.out.println(budget);
        System.out.println(cost);
        System.out.println(cart);
    }      
}
