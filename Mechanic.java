public class Mechanic extends Thread{
    private String state;
    private int noMechanic;
    private Race race;

    public Mechanic(Race race, int n){
        state = "Available";
        noMechanic = n;
        this.race = race;
    }

    @Override
    public void run() {
        while(!race.isFinished) {
            // Checar si es requerido
        }
        state = "Finished";
    }

    public String getCurrentState() {
        return state;
    }
    
}
