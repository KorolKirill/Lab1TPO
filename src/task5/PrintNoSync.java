package task5;


public class PrintNoSync extends Thread{
    private String text;

    PrintNoSync(String text){
        this.text = text;
    }
    public void run(){
        for(int l = 0; l < 10; l++){

            for (int i = 0; i<100; i++){
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
