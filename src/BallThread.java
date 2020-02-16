public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        try {
            while (!(b.getX() <= 180 && b.getX() >= 120 && b.getY() <= 180 && b.getY() >= 120)) {
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);


            }
            b.move();
        } catch (
                InterruptedException ex) {
            System.out.println("Ups,i did it again...");
        }
    }
}
