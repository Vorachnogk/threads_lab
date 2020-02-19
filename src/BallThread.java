public class BallThread extends Thread {
    private Ball b;
    private Thread thread;

    public BallThread(Ball ball) {
        b = ball;
    }

    public BallThread(Ball ball, Thread thread)
    {
        this(ball);
        this.thread=thread;
    }

    @Override
    public void run() {
        try {
            if(thread!=null){
                thread.join();
            }
            for (int i = 0; i < 1000; i++) {

                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);

            }
        } catch (
                InterruptedException ex) {
            System.out.println("Ups,i did it again...");
        }
    }
}
