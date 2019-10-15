package src.jantarFilosofo;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *@author luizASSilveira
 **/
public class Philosophes extends Thread{
    private static AtomicInteger id = new AtomicInteger(0);
    private JantarFilosofos jF;
    private int idFilosofo;

    public Philosophes(JantarFilosofos jF) {
        this.jF = jF;
        this.idFilosofo = this.id.getAndAdd(1);
    }
    @Override
    public void run(){
        Random number = new Random();
        while (true){
            try {
                this.jF.take(this.idFilosofo);
                Thread.sleep(number.nextInt(2000));
                System.out.println("Filosofo " + this.idFilosofo + ": Pensando na Vida");
                this.jF.release(this.idFilosofo);
                Thread.sleep(number.nextInt(1000));
            }catch (InterruptedException e){}
        }
    }
}
