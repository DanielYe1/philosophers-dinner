public class Filosofo implements Runnable{
    int id;
    Estado estado;
    private Garfo garfo1, garfo2;

    public Filosofo(int id, Estado estado, Garfo garfo1, Garfo garfo2) {
        this.id = id;
        this.estado = estado;
        this.garfo1 = garfo1;
        this.garfo2 = garfo2;
    }

    public void comer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void pensar(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void run(){
        while(true){
            estado.pegaGarfos(id, garfo1, garfo2);
            comer();
            estado.liberaGarfos(id, garfo1, garfo2);
            pensar();
        }
    }


}
