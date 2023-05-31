package task5;


public class Main {
    public static void main(String[] args) {
        Object lock = new Object();

        PrintSync p3 = new PrintSync(1,"-",lock);
        PrintSync p4 = new PrintSync(2,"|",lock);

        PrintNoSync p5 = new PrintNoSync("-");
        PrintNoSync p6 = new PrintNoSync("|");
        p3.start();
        p4.start();


    }
}
