import java.awt.Color;

public class Pits extends Buffer{
    protected Mechanic mechanic;

    public Pits(Mechanic mechanic) {
        super(mechanic.race, mechanic.getNumber());
        this.mechanic = mechanic;
    }
    /*
    public Mechanic selectMechanic(){
        Mechanic mechanic = null;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if(mechanics[i].getCurrentState() == "Waiting") {
                mechanic = mechanics[i];
            }
        }
        return mechanic;
    } */
    public void fix(String runnername){
        // Logica de arreglar carro
        race.updateBufferWindow(1); // number 1 updates pits label on buffer window
        mechanic.setCurrentState("Working");
        mechanic.table.changeState(mechanic.getNumber(), 2, runnername);
        mechanic.table.changeState(mechanic.getNumber(), 2, Color.YELLOW);
        race.waitToWork();
        try {
            Thread.sleep(1000 + rand.nextInt(1000));
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        mechanic.setCurrentState("Waiting");
        mechanic.table.changeState(mechanic.getNumber(), 2, "");
        mechanic.table.changeState(mechanic.getNumber(), 1, Color.CYAN);
        race.workToWait();
        this.isOccupied = false;
        race.updateBufferWindow(1);
    }
}
