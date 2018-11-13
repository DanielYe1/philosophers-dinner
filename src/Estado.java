import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Estado {
    private Lock mutex = new ReentrantLock();
    Condition[] cond = new Condition[5];
    String[] estado = new String[5];
    int[] id = new int[5];

    public Estado() {
        for (int i = 0; i < 5; i++) {
            id[i] = i;
            estado[i] = "pensando";
            cond[i] = mutex.newCondition();
        }
    }

    public void pegaGarfos(int id, Garfo garfo1, Garfo garfo2) {
        mutex.lock();
        try {
            estado[id] = "com-fome";
            while (!garfo1.isLivre() || !garfo2.isLivre()) {
                cond[id].await();
            }
            garfo1.setLivre(false);
            garfo2.setLivre(false);
            estado[id] = "comendo";
            printaEstado(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }

    public void liberaGarfos(int id, Garfo garfo1, Garfo garfo2) {
        mutex.lock();
        estado[id] = "pensando";
        garfo1.setLivre(true);
        garfo2.setLivre(true);
        cond[(id + 1) % 5].signalAll();
        cond[(id + 4) % 5].signalAll();
        mutex.unlock();
    }

    private void printaEstado(int id) {
        for (int i = 0; i < 5; i++) {
            System.out.printf(estado[i] + " ");
        }
        System.out.println("(" + (id + 1) + ")");
    }

}
