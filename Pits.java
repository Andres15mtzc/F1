public class Pits {
    private int MAX_CAPACITY;
    private Mechanic[] mechanics;

    public Pits(Mechanic[] mechanics) {
        MAX_CAPACITY = mechanics.length;
        this.mechanics = mechanics;
    }

    public Mechanic selectMechanic(){
        Mechanic mechanic = null;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if(mechanics[i].getCurrentState() == "Waiting") {
                mechanic = mechanics[i];
            }
        }
        return mechanic;
    }
}
