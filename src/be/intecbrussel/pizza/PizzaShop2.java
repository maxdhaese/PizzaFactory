package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaShop2 extends Pizza implements Serializable {
    //Create a class for pizzashop2 that makes mozzarella pizza's

    private final String Type = "Mozzarella Pizza";

    public PizzaShop2() {
    }

    @Override
    public String toString() {
        return
                "Sold: " + Type ;
    }
}
