package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaFactory2 extends Pizza implements Serializable {
    //Create a class for pizzafactory2 that makes mozzarella pizza's

    private final String Type = "Mozzarella Pizza";

    public PizzaFactory2() {
    }

    @Override
    public String toString() {
        return  "Made: " + Type ;
    }
}
