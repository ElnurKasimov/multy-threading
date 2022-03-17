import java.util.Date;

public class FirstTask {
    private static int counter=0;
    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread( () ->  {
            System.out.println("Со времени запуска программы прошло: ");
            while (true) {
                try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                counter++;

                synchronized (MONITOR) {
                    if (counter%5 == 0) {
                        MONITOR.notify();
                    } else {
                        System.out.println(counter + " сек");
                    }
                }
            }
            });

            Thread threadB = new Thread( () -> {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ого,  уже прошло " +  counter + " сек");
                    }
                }
            });

        threadA.start();
        threadB.start();

    }
}
