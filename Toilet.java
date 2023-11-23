public class Toilet extends Buffer{
    public Toilet(int n) {
        super(n);
    }

    public void pee() {
        try {
            Thread.sleep(8000 + rand.nextInt(4000));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.isOccupied = false;
    }
}
