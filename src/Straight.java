public class Straight {

    public static void simpleMultiplying(Matrix A, Matrix B, Matrix C) {
        for (int i = 0; i < A.getRows(); i++) {
            for (int j = 0; j < B.getCols(); j++) {
                for (int k = 0; k < B.getRows(); k++) {
                    int value = C.getElement(i, j) + A.getElement(i, k) * B.getElement(k, j);
                    C.setElement(i, j, value);
                }
            }
        }
    }

    public static void blockMultiply(Matrix A, Matrix B, Matrix C, int proc) {
        int lengthOfSections = A.getRows() / proc;               // Кількість рядків на один потік
        Thread[] threads = new Thread[proc];                     // Масив потоків
        // кожному потоку передаємо його підзадачі
        for (int i = 0; i < threads.length; i++) {
            if (i < threads.length - 1) {
                threads[i] = new Thread(new BlockThread(A, B, C,
                        i * lengthOfSections, (i + 1) * lengthOfSections));
            } else {
                threads[i] = new Thread(new BlockThread(A, B, C,
                        i * lengthOfSections, C.getRows()));
            }
            threads[i].start();
        }

        // чекаємо завершення виконання потоків
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}