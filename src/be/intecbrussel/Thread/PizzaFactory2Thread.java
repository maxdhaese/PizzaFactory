package be.intecbrussel.Thread;

import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.PizzaFactory2;
import be.intecbrussel.pizza.WareHouseAdd;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PizzaFactory2Thread extends Thread {

    private ArrayList<Pizza> wareHouse;
    private WareHouseAdd wareHouseAdd;
    private ObjectOutputStream outputStream;

    public PizzaFactory2Thread(ArrayList<Pizza> wareHouse, WareHouseAdd wareHouseAdd, ObjectOutputStream outputStream) {
        this.wareHouse = wareHouse;
        this.wareHouseAdd = wareHouseAdd;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            if (wareHouse.size() < 15){
                try {
                    Pizza pizza = new PizzaFactory2();
                    outputStream.writeObject(pizza);
                    wareHouseAdd.addPizza(pizza,wareHouse);
                    Thread.sleep(200);

                }catch (IOException e){
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else {
                this.interrupt();
            }
        }
    }
}
