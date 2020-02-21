public class Counter {
    protected int count;

    public Counter() {
        this.count = 0;
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increm() {
        ++this.count;
    }

    public void decrem() {
        --this.count;
    }
}
