import java.util.Random;

public abstract class Buffer {
    public boolean isOccupied;
    private int number;
    public Random rand;

    public Buffer(int n) {
        this.isOccupied = false;
        this.number = n;
        this.rand = new Random();
    }

    public int getNumber() {
        return number;
    }
}
