public class Main {

    public static void main(String[] args) {
        Garfo[] garfos = new Garfo[5];
        Filosofo[] filosofos = new Filosofo[5];
        Estado estado = new Estado();
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo();
        }
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, estado, garfos[i], garfos[(i+4)%5]);
            new Thread(filosofos[i]).start();
        }
    }
}
