import java.util.Scanner;

public class SecondTask {
    private static int counter = 1;
    private static final Object MONITOR = new Object();

    public static void fizz(int limit) {
        if (counter % 3 == 0 && counter % 5 != 0 && counter <= limit) {
            System.out.print("fizz, ");
            counter++;
        }
    }

    public static void buzz(int limit) {
        if (counter % 5 == 0 && counter % 3 != 0 && counter <= limit) {
            System.out.print("buzz, ");
            counter++;
        }
    }

    public static void fizzbuzz(int limit) {
        if (counter % 5 == 0 && counter % 3 == 0 && counter <= limit) {
            System.out.print("fizzbuzz, ");
            counter++;
        }
    }

    public static void number(int limit) {
        if (counter % 5 != 0 && counter % 3 != 0 && counter <= limit) {
            System.out.print(counter + ", ");
            counter++;
        }
    }


    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       System.out.print("Введите число, до которого должна работать программа : ");
       int limit = sc.nextInt();

            Thread threadA = new Thread(() -> {
                while (counter < limit) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        fizz(limit);
                    }
                }
            });

            Thread threadB = new Thread(() -> {
                while (counter < limit) {

                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        buzz(limit);
                    }
                }
            });

            Thread threadC = new Thread(() -> {
                while (counter < limit) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        fizzbuzz(limit);
                    }
                }
            });

            Thread threadD = new Thread(() -> {
                while (counter <= limit) {
                    synchronized (MONITOR) {
                        number(limit);
                        MONITOR.notifyAll();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();

        }
}
