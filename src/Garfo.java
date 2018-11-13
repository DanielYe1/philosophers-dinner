import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Garfo {
    private boolean livre;

    public Garfo() {
        this.livre = true;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }
}
