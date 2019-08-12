package be.intecbrussel.Thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PizzaQueue extends Thread {
    private Queue<String> pizzaQueue = new ConcurrentLinkedQueue<String>();

    public PizzaQueue(Queue<String> pizzaQueue) {
        this.pizzaQueue = pizzaQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Pizzafile.txt"));
                outputStream.writeObject(pizzaQueue);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
