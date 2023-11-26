import java.util.Random;

public abstract class Buffer {
    protected Race race;
    public boolean isOccupied;
    private int number;
    public Random rand;

    public Buffer(Race race, int n) {
        this.race = race;
        this.isOccupied = false;
        this.number = n;
        this.rand = new Random();
    }

    public int getNumber() {
        return number;
    }
}
