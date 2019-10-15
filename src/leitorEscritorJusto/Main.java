package src.leitorEscritorJusto;
/**
 * Implemente e teste duas soluções para o problema dos Leitores-Escritores usando semárofos ou monitores que:
 * -> não cause inanição (*starvation*) de leitores ou escritores.
 *@author luizASSilveira
 **/
public class Main {
    public static void main(String[] args) {
        ReaderWriter rW = new ReaderWriter();
        new Thread(new Leitor(rW)).start();
        new Thread(new Leitor(rW)).start();
        new Thread(new Leitor(rW)).start();
        new Thread(new Leitor(rW)).start();
        new Thread(new Leitor(rW)).start();

        new Thread(new Escritor(rW)).start();
        new Thread(new Escritor(rW)).start();
    }
}
