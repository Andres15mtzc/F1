import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        // Falta implementar que muestre el lugar en el que llegó, el tiempo que hizo y el gráfico visual
        
        int noLaps = validateNum(JOptionPane.showInputDialog("Number of laps:"));
        int noRunners = validateNum(JOptionPane.showInputDialog("Number of runners:"));
        int noViewers = Integer.parseInt(JOptionPane.showInputDialog("Number of viewers:"));
        int noMechanics = validateNum(JOptionPane.showInputDialog("Number of mechanics:"));
        int noGasStations = validateNum(JOptionPane.showInputDialog("Capacity of gas station:"));
        int noToilets = validateNum(JOptionPane.showInputDialog("Capacity of toilets:"));
        
        Race race = new Race(noLaps, noRunners, noMechanics, noViewers, noGasStations, noToilets);
        race.start();            
    }

    private static int validateNum(String value){
        int num;
        try{
            num = Integer.parseInt(value);
        }catch(NumberFormatException e){
            return 1;
        }
        return num;
    }
}
