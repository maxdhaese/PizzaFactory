package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaShop1 extends Pizza implements Serializable {
    //Create a class for pizzashop1 that sells pepperoni pizza's

    private final String Type = "Pepperoni Pizza";

    public PizzaShop1() {

    }

    @Override
    public String toString() {
        return
                "Sold: " + Type ;
    }
}

