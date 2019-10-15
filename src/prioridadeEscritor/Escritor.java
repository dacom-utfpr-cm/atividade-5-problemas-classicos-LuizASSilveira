package src.prioridadeEscritor;
/**
 *@author luizASSilveira
**/
import java.util.Random;
public class Escritor extends Thread{
    private ReaderWriter readerWriter;

    public Escritor(ReaderWriter rd) {
        this.readerWriter = rd;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true){
            try{
                this.readerWriter.startWrite();
                System.out.println(this.getName() + " Escrevendo");
                Thread.sleep(rand.nextInt(2000));
                this.readerWriter.endWrite();
                Thread.sleep(rand.nextInt(8000));

            } catch (InterruptedException e){}
        }
    }
}
