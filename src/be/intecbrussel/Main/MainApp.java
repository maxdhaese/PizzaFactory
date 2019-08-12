package be.intecbrussel.Main;

import be.intecbrussel.Thread.PizzaFactory1Thread;
import be.intecbrussel.Thread.PizzaFactory2Thread;
import be.intecbrussel.pizza.Pizza;
import be.intecbrussel.pizza.PizzaFactory1;
import be.intecbrussel.pizza.WareHouseAdd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        File file = new File("PizzaFile.txt");

        ArrayList<Pizza> wareHouse = new ArrayList<>();
        WareHouseAdd wareHouseAdd = new WareHouseAdd();

        try {
            ObjectOutputStream f1OutputStream = new ObjectOutputStream(new FileOutputStream(file));
            ObjectOutputStream f2OutPutStream = new ObjectOutputStream(new FileOutputStream(file));

            Thread thread1 = new PizzaFactory1Thread(wareHouse, wareHouseAdd, f1OutputStream);
            Thread thread2 = new PizzaFactory2Thread(wareHouse, wareHouseAdd, f2OutPutStream);

            thread1.start();
            thread2.start();

            System.out.println("Preparing Pizza's");

            thread1.join();
            thread2.join();

            System.out.println("Pizza's in the warehouse: " +wareHouse.size());



        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
