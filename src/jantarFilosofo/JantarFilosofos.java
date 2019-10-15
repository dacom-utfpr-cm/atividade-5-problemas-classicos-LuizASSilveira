package src.jantarFilosofo;

import java.util.concurrent.Semaphore;
/**
 *@author luizASSilveira
 **/
class JantarFilosofos {
    private Semaphore[] garfo = null;
    private int numeroPhilosophes = 0;

    public JantarFilosofos(int numeroPhilosophes) {
        this.numeroPhilosophes = numeroPhilosophes;
        this.garfo = new Semaphore[this.numeroPhilosophes];
        for (int i=0; i<this.numeroPhilosophes; i++){
            this.garfo[i] = new Semaphore(1);
        }
    }

    public void take(int idPhilosopher) throws InterruptedException{
        while (true){
            //Tenta pegar os dois evitando deadlock
            if(!this.garfo[idPhilosopher].tryAcquire() && !this.garfo[(idPhilosopher + 1) % this.numeroPhilosophes].tryAcquire()){
                break;
            }
        }
    }

    public void release(int idPhilosopher) throws InterruptedException{
        this.garfo[idPhilosopher].release();
        this.garfo[(idPhilosopher + 1) % this.numeroPhilosophes].release();
    }


}
