public class Begin {

    public static void main(String[] args) {
        Count count = new Count();
        CountThread decrement = new CountThread(count::decrem);
        CountThread increment = new CountThread(count::increm);
        increment.start();
        decrement.start();
        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException ex) {
            System.out.println("Ups,i did it again...");
        }
        System.out.println(count.getCount());
    }
}