public class SticksThread extends Thread {
    private char string;

    public SticksThread(char string) {
        this.string = string;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(string);
            try {
                sleep(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}