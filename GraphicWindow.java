import javax.swing.JFrame;

public class GraphicWindow extends JFrame implements Runnable {
    Race race;
    MyCanvas myC;

    public GraphicWindow(Race race) {
        this.race = race;
    }

    private void crearVentana(String name) {
        this.setTitle(name);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myC = new MyCanvas(race);
        this.add(myC);
        this.setVisible(true);
    }

    @Override
    public void run() {
        crearVentana("Map");
        while (!race.isFinished) {
            myC.paint(getGraphics());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
