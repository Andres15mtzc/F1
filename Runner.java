import java.util.Random;

public class Runner extends Thread{
    private Random rand;
    private int laps = 70;
    private int currentLaps;
    private String state;
    private int noRunner;
    private Race race;

    public Runner(Race race, int n){
        rand = new Random();
        state = "Running";
        currentLaps = 0;
        noRunner = n;
        this.race = race;
    }

    @Override
    public void run() {
        for (int i = 0; i < laps; i++) {
            // Crashing
            if(rand.nextInt(100) < 2) {
                state = "Crashed";
                break;
            }
            // Pits
            if(rand.nextInt(100) < 10){
                state = "Pits";
                // Mandar a los pits
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            // Gasoline
            else if(rand.nextInt(100) < 5){
                state = "Gasoline";
                // Mandar a la gasolinera
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            state = "Running";
            currentLaps++;
        }
        if(state != "Crashed") {
            state = "Finished";
            // Colocar en tabla de resultados
        }
        
    }

    public int getCurrentLaps() {
        return currentLaps;
    }

    public String getCurrentState() {
        return state;
    }
}
