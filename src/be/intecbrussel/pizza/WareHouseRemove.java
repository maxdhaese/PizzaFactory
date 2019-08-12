package be.intecbrussel.pizza;

import java.util.ArrayList;

public class WareHouseRemove {
    private int count;
    private Object monitor = new Object();

    public WareHouseRemove() {
    }

    public void removePizza(Pizza pizza, ArrayList<Pizza> wareHouse){
        synchronized (monitor){
            if (count > 1 && count < 15){
                wareHouse.remove(pizza);
                count--;

            }else {
                System.out.println("Waiting for production to make new pizza's");
            }
        }
    }
}
