package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaFactory1 extends Pizza implements Serializable {
    private final String Type = "Pepperoni Pizza";

    public PizzaFactory1() {
    }

    @Override
    public String toString() {
        return
                "Type:'" + Type + '\'';
    }

}
