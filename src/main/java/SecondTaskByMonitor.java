import java.util.Scanner;

public class SecondTaskByMonitor {
    private static volatile int counter=1;
    private static final Object MONITOR_A = new Object();
    private static final Object MONITOR_B = new Object();
    private static final Object MONITOR_C = new Object();

    public static void number () {

       synchronized (MONITOR_A) {
           MONITOR_A.notify();
       }
        System.out.print(counter + ", ");
        counter++;
    }

    public  static  void fizz () {
        if (counter %3 == 0) {
            System.out.print("fizz, ");
        }
        synchronized (MONITOR_A) {
            try {
                MONITOR_A.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static  void buzz () {
        if (counter %5 == 0) {
            System.out.print("buzz, ");
        }
        /*
        try {
            MONITOR.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */
    }

    public static void  fizzbuzz () {
        if (counter %3 == 0 && counter %5 == 0) {
            System.out.print("fizzbuzz, ");
        }
        /*
        try {
            MONITOR.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число, до которого должна работать программа : ");
        int limit = sc.nextInt();

    Thread threadA = new Thread( () ->{
        while (counter <= limit ) {
            fizz();

        }
    });

        Thread threadB = new Thread( () ->{
            while (counter <= limit ) {
                buzz();
            }
        });

        Thread threadC = new Thread( () ->{
            while (counter <= limit ) {
                fizzbuzz();
            }
        });

        Thread threadD = new Thread( () ->{
            while (counter <= limit ) {
                number();
            }
        });

        threadA.start();
       //threadB.start();
       //threadC.start();
       threadD.start();
    }
}
