package be.intecbrussel.pizza;

import java.io.Serializable;

public class PizzaFactory2 extends Pizza implements Serializable {
    private final String Type = "Mozzarella Pizza";

    public PizzaFactory2() {
    }

    @Override
    public String toString() {
        return  "Type:'" + Type + '\'';
    }
}
