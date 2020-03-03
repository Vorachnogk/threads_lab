// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

public class BankTest {

    public static final int NACCOUNTS = 10;
    public static final int INITIAL_BALANCE = 10000;

    public static void main(String[] args) {

        // Створити банк з 10 рахунками та балансом 10000
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        // ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < NACCOUNTS; i++){
            TransferThread t = new TransferThread(b, i, INITIAL_BALANCE);
            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            // executor.submit(t);
            t.start () ;
        }
    }
}