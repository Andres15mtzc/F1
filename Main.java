import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        int noLaps = Integer.parseInt(JOptionPane.showInputDialog("Number of laps:"));
        int noRunners = Integer.parseInt(JOptionPane.showInputDialog("Number of runners:"));
        int noViewers = Integer.parseInt(JOptionPane.showInputDialog("Number of viewers:"));
        int noMechanics = Integer.parseInt(JOptionPane.showInputDialog("Number of mechanics:"));
        int noGasStations = Integer.parseInt(JOptionPane.showInputDialog("Capacity of gas station:"));
        int noToilets = Integer.parseInt(JOptionPane.showInputDialog("Capacity of toilets:"));

        Race race = new Race(noLaps, noRunners, noMechanics, noViewers, noGasStations, noToilets);
        race.start();

        new BufferWindow();
    }
}
