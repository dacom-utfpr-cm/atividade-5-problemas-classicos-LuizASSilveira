package src.leitorEscritorJusto;
/**
 *@author luizASSilveira
 **/
public class Leitor extends Thread{
    private ReaderWriter readerWriter;

    public Leitor(ReaderWriter rd) {
        this.readerWriter = rd;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.readerWriter.startRead();
                System.out.println(this.getName() + " Lendo");
                Thread.sleep(1000);
                this.readerWriter.endRead();
                Thread.sleep(3000);
            } catch (InterruptedException e){}
        }
    }
}
