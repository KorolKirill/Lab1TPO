package task5;

public class PrintSync extends Thread{
    private Object lock;
    private String text;
    private int number;
    PrintSync(int number, String text, Object lock){
        this.number = number;
        this.text = text;
        this.lock = lock;
    }

    public void  run(){
        for(int l = 0; l < 100; l++){
            for (int i = 0; i<100; i++){
                synchronized(lock){
                    lock.notifyAll();
                    try {
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(text);

                }
            }
            if(number == 1)
                System.out.println();
        }
    }
}
