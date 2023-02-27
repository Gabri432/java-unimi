package shopping_cart;

import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cart cart = new Cart();
        int budget = 0;
        float cost = 0;
        while (input.hasNext()) {
            String data = input.next();
            if (!data.contains(",")) {
                budget = Integer.parseInt(data);
            } else {
                String[] prdData = data.split(",");
                String name = prdData[0];
                float price = Float.parseFloat(prdData[1]);
                int quantity = Integer.parseInt(prdData[2]);
                cost += price*quantity;
                cart.add(new Product(name, price));
            }
        }
        input.close();
        System.out.println(budget);
        System.out.println(cost);
    }      
}
