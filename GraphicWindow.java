import javax.swing.JFrame;

public class GraphicWindow extends JFrame implements Runnable {
    Race race;
    
    public GraphicWindow(Race race){
        this.race = race;
    }

    private void crearVentana(String name) {
        this.setTitle(name);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MyCanvas myC = new MyCanvas(race);
        this.add(myC);
        this.setVisible(true);
    }

    @Override
    public void run() {
        crearVentana("Map");
        System.out.println("Starting work");
    }
}
