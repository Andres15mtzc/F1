import java.util.Random;

public class Viewer extends Thread{
    private Random rand;
    private String state;
    private Race race;

    public Viewer(Race race, int n){
        rand = new Random();
        state = "Watching";
        this.race = race;
    }

    @Override
    public void run() {
        while(!race.isFinished){
            // Need to pee
            if (rand.nextInt(100) < 1) {
                state = "Gone";
                break;
            }
            if (rand.nextInt(100) < 10) {
                // Mandar a orinar
                state = "Pee";
            }
            state = "Watching";
        }
    }
    
    public String getCurrentState() {
        return state;
    }
    
}
