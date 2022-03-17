class SintacsisThreadTest {


public static void main(String[] args) throws InterruptedException {
/*
    class Anonim implements Runnable {
        @Override
        public void run() {
            System.out.println("Running with Anonim ...");
        }
    }
    Runnable r = new Anonim();
    Thread endlessThread = new Thread(r);

   -------  упрощенный  синтактический вариант без создания анонимного класса
   Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running without Anonim ...");
        };
        Thread endlessThread = new Thread(r);

         --------   еще более упрощенный  синтактический вариант,

        Thread endlessThread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Running without Anonim ...");
        }
    }
        );

      //  --- самый упрощенный вариант с лямбда-выражением

       Thread endlessThread = new Thread(
             () -> System.out.println("Running without Anonim ...")
         );

        */

        Thread endlessThread = new Thread() {
                @Override
                public void run() {
                        while ( ! isInterrupted() ) {
                                System.out.println("Running with lambda ...");
                        }
                }
        };

        Thread endlessThreadA = new Thread(); // по умолчанию создает поток
        // с такими параметрами Thread (null, null, gname) :))


        endlessThread.start();




        endlessThread.start();

        Thread.sleep(1000);

        endlessThread.interrupt();
    }
}