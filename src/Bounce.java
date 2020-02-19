public class Bounce {

    public static void main(String[] args) {

        SticksThread sticksThread1 = new SticksThread('|');
        sticksThread1.start();
        SticksThread sticksThread2 = new SticksThread('-');
        sticksThread2.start();
    }
}