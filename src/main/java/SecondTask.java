import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SecondTask {
    private static int counter=1;
    private static Semaphore semaphore;

    public  static  void fizz () {
        if (counter %3 == 0 && counter%5 != 0) {
            System.out.print("fizz, ");
            counter++;
        }
    }

    public  static  void buzz () {
        if (counter %5 == 0 && counter%3 != 0) {
            System.out.print("buzz, ");
            counter++;
        }
    }

    public  static  void fizzbuzz () {
        if (counter %5 == 0 && counter%3 == 0) {
            System.out.print("fizzbuzz, ");
            counter++;
        }
    }

    public  static  void number () {
        if (counter %5 != 0 && counter%3 != 0) {
            System.out.print( counter + ", ");
            counter++;
        }
    }


    public static void main(String[] args) {
        semaphore = new Semaphore(4);

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число, до которого должна работать программа : ");
        int limit = sc.nextInt();

        Thread threadA = new Thread( () ->{
            while (counter < limit ) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fizz();
                semaphore.release();
            }
        });

        Thread threadB = new Thread( () ->{
            while (counter < limit ) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buzz();
                semaphore.release();
            }
        });

        Thread threadC = new Thread( () ->{
            while (counter < limit ) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fizzbuzz();
                semaphore.release();
            }
        });

        Thread threadD = new Thread( () ->{
            while (counter < limit ) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number();
                semaphore.release();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
