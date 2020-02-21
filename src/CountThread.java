public class CountThread extends Thread {
    Runnable runnable;

    public CountThread(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                this.runnable.run();
                sleep(1);
            }
        } catch (InterruptedException ex) {
            System.out.println("Ups,i did it again...");
        }
    }
}
