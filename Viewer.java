import java.awt.Color;
import java.util.Random;

public class Viewer extends Thread{
    private Random rand;
    private int number;
    private String currentState;
    private Race race;
    public Table table;

    public Viewer(Race race, int n, Table table){
        super("Viewer " + (n+1));
        rand = new Random();
        number = n+1;
        currentState = "Watching";
        this.race = race;
        this.table = table;
        table.changeState(number, 1, Color.CYAN);
    }

    @Override
    public void run() {
        while(!race.isFinished){
            if (currentState != "Watching") {
                currentState = "Watching";
                table.changeState(number, 1, Color.CYAN);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // Need to pee
            if (rand.nextInt(100) < 1) {
                currentState = "Gone";
                table.changeState(number, 3, Color.RED);
                break;
            }
            if (rand.nextInt(100) < 10) {
                Toilet toilet;
                do {
                    toilet = race.getFreeToilet();
                } while (toilet == null);
                currentState = "Peeing";
                table.changeState(number, 2, Color.YELLOW);
                toilet.pee();
            }
        }
        currentState = "Gone";
        table.changeState(number, 3, Color.RED);
    }
    
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
    
}
