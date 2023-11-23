import java.util.Random;

public class GasStation extends Buffer{
    public GasStation(int n) {
        super(n);
    }

    public void refill() {
        try {
            Thread.sleep(4000 + rand.nextInt(2000));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.isOccupied = false;
    }
}
