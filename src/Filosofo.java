public class Filosofo implements Runnable{
    int id;
    private Garfo garfo1, garfo2;

    public Filosofo(int id, Garfo garfo1, Garfo garfo2) {
        this.id = id;
        this.garfo1 = garfo1;
        this.garfo2 = garfo2;
    }

    public void run(){

    }
}
