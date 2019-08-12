package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaFactory1 extends Pizza implements Serializable {
    //Create a Class for pizzafactory1 that makes pepperoni pizza's

    private final String Type = "Pepperoni Pizza";

    public PizzaFactory1() {
    }

    @Override
    public String toString() {
        return
                "Made: " + Type ;
    }

}
