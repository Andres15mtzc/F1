import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        int noLaps = Integer.parseInt(JOptionPane.showInputDialog("Number of laps:"));
        int noRunners = Integer.parseInt(JOptionPane.showInputDialog("Number of runners:"));
        int noViewers = Integer.parseInt(JOptionPane.showInputDialog("Number of viewers:"));
        int noMechanics = Integer.parseInt(JOptionPane.showInputDialog("Number of mechanics:"));
        int noGasStations = Integer.parseInt(JOptionPane.showInputDialog("Capacity of gas station:"));
        int noToilets = Integer.parseInt(JOptionPane.showInputDialog("Capacity of toilets:"));

        /*
        // String strWait = JOptionPane.showInputDialog("How many millis will it wait:");
        // int nWait = Integer.parseInt(strWait);
        String[] labelsNames = new String[] {"", "Running", "On pits", "Filling gas", "Crashed", "Finished"};
        // agregar en la tabla de runner, a cuál pit se va cada corredor (o a qué bomba de gasolina)
        String[] labelsNames2 = new String[] {"", "Waiting", "Working", "Finished"}; 
        String[] labelsNames3 = new String[] {"", "Watching", "Peeing", "Gone"};

        Table table = new Table("Runner", labelsNames);
        Table table2 = new Table("Mechanic", labelsNames2);
        Table table3 = new Table("Viewer", labelsNames3);

        new Window(null, "F1 Runners", table);
        new Window(null, "F1 Mechanics", table2);
        new Window(null, "F1 Viewers", table3); */

        Race race = new Race(noLaps, noRunners, noMechanics, noViewers, noGasStations, noToilets);
        race.start();

       new BufferWindow();
    }
}
