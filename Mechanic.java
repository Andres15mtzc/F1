import java.awt.Color;

public class Mechanic extends Thread{
    private String currentState;
    private int number;
    private Race race;
    public Table table;

    public Mechanic(Race race, int n, Table table){
        super("Mechanic " + (n+1));
        currentState = "Waiting";
        number = n+1;
        this.race = race;
        this.table = table;
        table.changeState(number, 1, Color.CYAN);
    }

    @Override
    public void run() {
        while(!race.isFinished) {
            // Waiting
            System.out.println("");
        }
        currentState = "Finished";
        table.changeState(number, 3, Color.RED);
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public int getNumber() {
        return number;
    }

}
