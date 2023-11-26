import java.awt.Color;
import java.util.Random;

public class Runner extends Thread {
    private Random rand;
    private int laps;
    private int currentLaps;
    private String currentState;
    private int number;
    private Race race;
    public Table table;

    public Runner(Race race, int n, Table table, int laps) {
        super("Runner " + (n + 1));
        rand = new Random();
        currentState = "Running";
        currentLaps = 0;
        number = n + 1;
        this.laps = laps;
        this.race = race;
        this.table = table;
        table.changeState(number, 1, Color.CYAN);
        table.changeState(number, 6, currentLaps + "/" + laps);
    }

    @Override
    public void run() {
        for (int i = 0; i < laps; i++) {
            if (currentState != "Running") {
                currentState = "Running";
                table.changeState(number, 1, Color.CYAN);
            }
            try {
                Thread.sleep(8000 + rand.nextInt(4000));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // Crashing
            if (rand.nextInt(100) < 2) {
                currentState = "Crashed";
                table.changeState(number, 4, Color.RED);
                break;
            }
            // Pits
            if (rand.nextInt(100) < 10) {
                Pits pit;
                do {
                    pit = race.getFreePit();
                } while (pit == null);
                currentState = "On pits";
                table.changeState(number, 2, Color.LIGHT_GRAY);
                pit.fix();
            }
            // Gasoline
            else if (rand.nextInt(100) < 5) {
                GasStation gasStation;
                do {
                    gasStation = race.getFreeGasStation();
                } while (gasStation == null);
                currentState = "Filling gas";
                table.changeState(number, 3, Color.YELLOW);
                gasStation.refill();
            }

            currentLaps++;
            table.changeState(number, 6, currentLaps + "/" + laps);
        }
        if (currentState != "Crashed") {
            currentState = "Finished";
            table.changeState(number, 5, Color.GREEN);
            // Colocar en tabla de resultados
        }

    }

    public int getCurrentLaps() {
        return currentLaps;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
