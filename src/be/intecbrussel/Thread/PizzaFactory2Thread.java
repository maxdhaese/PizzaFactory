package be.intecbrussel.Thread;

import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.PizzaFactory2;
import be.intecbrussel.pizza.WareHouseAdd;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PizzaFactory2Thread extends Thread {

    private ArrayList<Pizza> wareHouse;
    private WareHouseAdd wareHouseAdd;
    private Queue<String> pizzaQueue = new ConcurrentLinkedQueue<String>();


    public PizzaFactory2Thread(ArrayList<Pizza> wareHouse, WareHouseAdd wareHouseAdd, Queue<String> pizzaQueue) {
        this.wareHouse = wareHouse;
        this.wareHouseAdd = wareHouseAdd;
        this.pizzaQueue = pizzaQueue;

    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (wareHouse.size() <= 1500) {
                try {
                    Pizza pizza = new PizzaFactory2();
                    wareHouseAdd.addPizza(pizza, wareHouse);
                    Thread.sleep(2000);
                    pizzaQueue.add("A Mozzarella pizza was made");
                    System.out.println("made a pizza Mozzarella");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.interrupt();
            }
        }
    }
}
