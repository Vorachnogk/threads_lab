public class Main {
    private static long start;

    public static void main(String[] args) {
        int[] processors = {2, 4, 8, 16};
        int[] sizes = {1000, 1500, 2000, 2500};

        for (int size : sizes) {
            Matrix A = new Matrix(size, size);
            Matrix B = new Matrix(size, size);
            System.out.println("\n-----------------------------------");
            System.out.println("\nРазмер матрицы: " + size);
            Matrix simpleC = new Matrix(A.getRows(), B.getCols(), 0);
            start = System.nanoTime();
            Straight.simpleMultiplying(A, B, simpleC);
            System.out.print("\nКлассическое перемножение матриц: ");
            finishNanoTimer();

            System.out.println("\n\nЛенточный алгоритм перемножения матриц: ");
            for (int p : processors) {
                Matrix blockC = new Matrix(A.getRows(), B.getCols(), 0);
                start = System.nanoTime();
                Straight.blockMultiply(A, B, blockC, p);
                System.out.print(p + " потоков:");
                finishNanoTimer();
            }
        }
    }

    public static void finishNanoTimer() {
        long finish = System.nanoTime();
        long time = finish - start;
        System.out.print((time / 1000000) + " мс.\t");
        start = 0;
    }
}