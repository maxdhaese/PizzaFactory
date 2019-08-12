package be.intecbrussel.pizza;

import java.util.ArrayList;

public class WareHouseAdd {

    private int count;
    private Object monitor = new Object();

    public WareHouseAdd() {
    }

    //A method that adds pizza's to the Warehouse list. For every pizza added, the count goes up.
    public void addPizza(Pizza pizza, ArrayList<Pizza> wareHouse) {
        synchronized (monitor) {
            if (count <= 1500) {
                wareHouse.add(pizza);
                count++;
            } else {
                System.out.println("Warehouse limit reached. Number of pizza's: " + count);
            }
        }
    }
    //A method that removes pizza's (sells them). For every pizza sold, the count goes down.
    public void removePizza(Pizza pizza, ArrayList<Pizza> wareHouse){
        synchronized (monitor){
            if (count < 1500){
                wareHouse.remove(pizza);
                count--;

            }else {
                System.out.println("Waiting for production to make new pizza's");
            }
        }
    }


}
