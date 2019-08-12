package be.intecbrussel.Main;

import be.intecbrussel.Thread.*;
import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.WareHouseAdd;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Pizza> wareHouse = new ArrayList<>();
        WareHouseAdd wareHouseAdd = new WareHouseAdd();
        Queue<String> pizzaQueue = new ConcurrentLinkedQueue<String>();

        //create the threads and start them
        try {
            Thread thread1 = new PizzaFactory1Thread(wareHouse, wareHouseAdd,pizzaQueue);
            Thread thread2 = new PizzaFactory2Thread(wareHouse, wareHouseAdd,pizzaQueue);
            Thread thread3 = new PizzaShop1Thread(wareHouse, wareHouseAdd,pizzaQueue);
            Thread thread4 = new PizzaShop2Thread(wareHouse,wareHouseAdd,pizzaQueue);
            Thread thread5 = new PizzaQueue(pizzaQueue);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

            System.out.println("Factory running.. Shop running..");

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();




            pizzaQueue.forEach(System.out::println);
            System.out.println("finished");



        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
