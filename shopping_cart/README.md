# Shopping cart
A simple program written in Java that replicates a shopping cart.

## Description
Mary is going to the supermarket to buy a list of products given by her mother. 
Mary has also been given a budget within she can buy the things her mother needs. In case Mary overcomes this budget she will have to remove some products from the shopping cart.

## Objective
The objective is to write the program that allows to perform the following operations:
- adding products to the shopping cart;
- removing products from;
- searching for a product in the shopping cart (so Mary can tell if it is missing); 
- listing the products of the shopping cart;

### Input (example)
- The first line of the input will be the budget set by Mary's mother;
- Every other line will represents a product with the associated price, and then the amount to buy;

```
50.00
Milk, 0.50, 3
Rice, 1.20, 1
Bread, 0.95, 2
Eggs, 2.50, 5
Chicken, 3.50, 1
Soda, 1.60, 2
Chips, 3.20, 1
Cheese, 3.50, 2
Toothpaste, 1.80, 2
Toilet-paper, 1.75, 2
Salad, 0.80, 2
Tomato, 0.65, 3

```

### Output
The output will differ according to the command insert by the user.
- `TOTAL` will tell the total amount of money that Mary spent, the rest and the total quantity of the things being bought:
```
TOTAL = 44.65, REST = 5.35, QUANTITY = 26.  
```

- The following message has to be prompted when Mary adds a product which overcomes the budget:
```
WARNING: to add this product you must remove another one first, otherwise you are overcoming the budget!
```

- `REMOVE:<product>` will allow Mary to remove a single product from her shopping cart (it is assumed that the product was in the shopping cart), prompting this:
```
<product> has been removed.
```

- `GET:<product>` will allow Mary to search for a product. If the product was in the shopping cart then the following message will appear:
```
Found <product> <n> times.
```

- otherwise:
```
No <product> was found.
```

## Extra
The program will produce an output also when the following commands are inserted:
- `LIST:PRICE` will order the products according to their price, from cheapest to most expensive;
- `LIST:NAME` will order the products alphabetically.


## Notes
- No limitations regarding the number or names of the classes.