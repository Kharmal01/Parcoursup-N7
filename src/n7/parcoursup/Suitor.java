package n7.parcoursup;

public class Suitor extends Suiting<Integer, Suitable> {

    private int unusedCapacity;
    private int usedCapacity;

    public Suitor(int id, String name, int capacity) {
        super(id, name, capacity);
        this.unusedCapacity = capacity;
        this.usedCapacity = 0;
    }

    public int getUnusedCapacity() {
        return unusedCapacity;
    }

    public void setUnusedCapacity(int unusedCapacity) {
        this.unusedCapacity = unusedCapacity;
    }
    public int getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }
}
