import java.nio.Buffer;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        String strThreads = JOptionPane.showInputDialog("Number of runners:");
        //int nThreads = Integer.parseInt(strThreads);
        String strThreads1 = JOptionPane.showInputDialog("Number of viewers:");
        //int nThreads = Integer.parseInt(strThreads);
        String strThreads2 = JOptionPane.showInputDialog("Capacity of pits:");
        //int nThreads = Integer.parseInt(strThreads);
        String strThreads3 = JOptionPane.showInputDialog("Capacity of gas station:");
        //int nThreads = Integer.parseInt(strThreads);
        String strThreads4 = JOptionPane.showInputDialog("Capacity of restrooms:");
        //int nThreads = Integer.parseInt(strThreads);

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
        new Window(null, "F1 Viewers", table3);


       new BufferWindow();
    }
}
