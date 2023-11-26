import java.util.Random;

public class GasStation extends Buffer{
    public GasStation(Race race, int n) {
        super(race, n);
    }

    public void refill() {
        race.updateBufferWindow(2); // number 2 updates pits label on buffer window
        try {
            Thread.sleep(4000 + rand.nextInt(2000));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.isOccupied = false;
        race.updateBufferWindow(2);
    }
}
