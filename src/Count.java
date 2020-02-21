public class Count extends Counter {
    public Count() {
    }

    @Override
    public synchronized void increm() {
        super.increm();
    }

    @Override
    public synchronized void decrem() {
        super.decrem();
    }
}
