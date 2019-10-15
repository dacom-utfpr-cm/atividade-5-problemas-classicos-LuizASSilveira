package src.leitorEscritorJusto;
/**
 *@author luizASSilveira
 **/
import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int numReaders = 0;
    private Semaphore mutex = new Semaphore(1,true);

    public void startRead() throws InterruptedException{
        this.mutex.acquire();
        this.numReaders++;
        this.mutex.release();
    }

    public void endRead() throws InterruptedException{
        this.mutex.acquire();
        this.numReaders--;
        this.mutex.release();
    }

    public void startWrite() throws InterruptedException{
        this.mutex.acquire();
    }

    public void endWrite() throws InterruptedException{
        this.mutex.release();
    }
}
