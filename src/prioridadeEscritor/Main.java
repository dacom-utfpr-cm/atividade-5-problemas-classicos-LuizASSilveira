package src.prioridadeEscritor;
/**
 * Implemente e teste duas soluções para o problema dos Leitores-Escritores usando semárofos ou monitores que:
 * -> npriorize os escritores.
 *@author luizASSilveira
**/

public class Main {
    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        new Thread(new Leitor(readerWriter)).start();
        new Thread(new Leitor(readerWriter)).start();
        new Thread(new Leitor(readerWriter)).start();
        new Thread(new Leitor(readerWriter)).start();
        new Thread(new Leitor(readerWriter)).start();

        new Thread(new Escritor(readerWriter)).start();
        new Thread(new Escritor(readerWriter)).start();
    }
}
