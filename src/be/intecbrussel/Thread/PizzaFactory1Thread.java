package be.intecbrussel.Thread;

import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.PizzaFactory1;
import be.intecbrussel.pizza.WareHouseAdd;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PizzaFactory1Thread extends Thread {

    private ArrayList<Pizza> wareHouse;
    private WareHouseAdd wareHouseAdd;
    private Queue<String> pizzaQueue = new ConcurrentLinkedQueue<String>();


    public PizzaFactory1Thread(ArrayList<Pizza> wareHouse, WareHouseAdd wareHouseAdd,Queue<String> pizzaQueue) {
        this.wareHouse = wareHouse;
        this.wareHouseAdd = wareHouseAdd;
        this.pizzaQueue = pizzaQueue;

    }

    //run method that will add a pizza to the warehouse list if the list is under 1500 pizza's.
    //Also add a message to the pizzaQueue that a pizza was made
    @Override
    public void run() {
        while (!isInterrupted()) {
            if (wareHouse.size() < 1500) {
                try {
                    Pizza pizza = new PizzaFactory1();
                    wareHouseAdd.addPizza(pizza, wareHouse);
                    Thread.sleep(2000);
                    pizzaQueue.add("A Pepperoni pizza was made");
                    System.out.println("made a pizza Pepperoni ");

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            } else {
                this.interrupt();
            }
        }
    }
}
