package src.prioridadeEscritor;
/**
 *@author luizASSilveira
 **/
import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int numReaders = 0;
    private Semaphore lLock = new Semaphore(1);
    private Semaphore wlock = new Semaphore(1);

    public void startRead() throws InterruptedException{
        this.lLock.acquire();
        this.numReaders++;
        this.lLock.release();
    }

    public void endRead() throws InterruptedException{
        this.lLock.acquire();
        this.numReaders--;
        this.lLock.release();
    }

    public void startWrite() throws InterruptedException{
        if(this.wlock.getQueueLength() == 0 && this.wlock.availablePermits() == 1){
            System.out.println("leitura Bloqueada");
            this.lLock.acquire();
        }
        this.wlock.acquire();
    }

    public void endWrite() throws InterruptedException{
        if(this.wlock.getQueueLength() == 0){
            this.lLock.release();
            System.out.println("leitura Liberada");
        }
        this.wlock.release();
    }
}
