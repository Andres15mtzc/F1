import javax.swing.JFrame;

public class GraphicWindow extends JFrame implements Runnable{
    private void crearVentana(String name){
        this.setTitle(name);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MyCanvas myC = new MyCanvas();
        this.add(myC);
        this.setVisible(true);
    }

    @Override
    public void run() {
        crearVentana("Map");
    }
}
