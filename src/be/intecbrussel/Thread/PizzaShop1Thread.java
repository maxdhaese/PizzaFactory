package be.intecbrussel.Thread;


import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.PizzaShop1;
import be.intecbrussel.pizza.WareHouseAdd;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PizzaShop1Thread extends Thread {

    private ArrayList<Pizza> wareHouse;
    private WareHouseAdd wareHouseAdd;
    private Queue<String> pizzaQueue = new ConcurrentLinkedQueue<String>();

    public PizzaShop1Thread(ArrayList<Pizza> wareHouse, WareHouseAdd wareHouseAdd,Queue<String> pizzaQueue){
        this.wareHouse = wareHouse;
        this.wareHouseAdd = wareHouseAdd;
        this.pizzaQueue = pizzaQueue;

    }
    //Method that will start selling pizza's every 5 seconds when the warehouse size is lower than 1500.
    //Also adding a message to the pizzaQueue that a pizza was sold
    @Override
    public void run() {
        while (!isInterrupted()){
            if (wareHouse.size() < 1500){
                try {
                    Pizza pizza = new PizzaShop1();
                    wareHouseAdd.removePizza(pizza,wareHouse);
                    Thread.sleep(5000);
                    pizzaQueue.add("A Pepperoni pizza was sold");
                    System.out.println("sold a pizza Pepperoni");

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else {
                this.interrupt();
            }
        }
    }
}
