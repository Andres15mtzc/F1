public class Toilet extends Buffer{
    public Toilet(Race race, int n) {
        super(race, n);
    }

    public void pee() {
        race.updateBufferWindow(3); // number 3 updates pits label on buffer window
        try {
            Thread.sleep(8000 + rand.nextInt(4000));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.isOccupied = false;
        race.updateBufferWindow(3);
    }
}
