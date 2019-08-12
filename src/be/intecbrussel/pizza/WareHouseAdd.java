package be.intecbrussel.pizza;

import java.util.ArrayList;

public class WareHouseAdd {
    private int count;
    private Object monitor = new Object();

    public WareHouseAdd() {
    }

    public void addPizza(Pizza pizza, ArrayList<Pizza> wareHouse) {
        synchronized (monitor) {
            if (count <= 15) {
                wareHouse.add(pizza);
                count++;
            } else {
                System.out.println("Warehouse limit reached. Number of pizza's: " + count);
            }
        }
    }
}
