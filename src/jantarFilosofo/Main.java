package src.jantarFilosofo;

import java.util.ArrayList;

/**
 * Implemente uma solução para o problema do Jantar dos Filósofos que não resulte em impasse (*deadlock*)
 *
 *@author luizASSilveira
 */

public class Main {
    public static void main(String[] args) {
        int numbFilosofos = 12;
        JantarFilosofos jf = new JantarFilosofos(numbFilosofos);

        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < numbFilosofos; i++) {
            arrayThread.add(i, new Thread(new Philosophes(jf))) ;
            arrayThread.get(i).start();
        }
    }
}
