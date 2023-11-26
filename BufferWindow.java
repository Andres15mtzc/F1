import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BufferWindow extends JFrame{

    private Pits[] pits;
    private GasStation[] gasStations;
    private Toilet[] toilets;
    private JPanel panel;
    private JLabel pitsLabel;
    private JLabel gasLabel;
    private JLabel toiletLabel;

    public BufferWindow(Pits[] pits, GasStation[] gasStations, Toilet[] toilets){

        this.gasStations = gasStations;
        this.pits = pits;
        this.toilets = toilets;

        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.panel = new JPanel();
        this.pitsLabel = new JLabel("Pits: " + pits.length + "/" + pits.length + " available");
        this.gasLabel = new JLabel("Gas Stations: " + gasStations.length +  "/" + gasStations.length + " available");
        this.toiletLabel = new JLabel("Toilets " + toilets.length +  "/" + toilets.length + " available");


        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JLabel("BUFFER MANAGER"));
        panel.add(pitsLabel);
        panel.add(gasLabel);
        panel.add(toiletLabel);

        this.getContentPane().add(panel);
    }

    public void updateWindow(int n){
        switch(n){
            case 1:
                pitsLabel.setText("Pits: " + getFreeSpaces(pits) +  "/" + pits.length + " available");
                break;
            case 2:
                gasLabel.setText("Gas Stations: " + getFreeSpaces(gasStations) +  "/" + gasStations.length + " available");
                break;
            case 3:
                toiletLabel.setText("Toilets: " + getFreeSpaces(toilets) +  "/" + toilets.length + " available");
                break;
            default: break;
        }
    }

    private int getFreeSpaces(Object[] buffer){
        int freeSpaces = 0;
        for(Object obj : buffer){
            if (obj instanceof Pits) {
                if(!((Pits) obj).isOccupied) {
                    freeSpaces++;
                }
            } else if (obj instanceof GasStation) {
                if(!((GasStation) obj).isOccupied) {
                    freeSpaces++;
                }
            } else if (obj instanceof Toilet) {
                if(!((Toilet) obj).isOccupied) {
                    freeSpaces++;
                }
            }
        }
        return freeSpaces;
    }
}
