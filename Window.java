import javax.swing.JFrame;

public class Window extends JFrame {

    //private CriticalThread[] ths;
    private String[] ths;

    public Window(String[] threads, String name, Table table) {
        ths = threads;
        this.setTitle(name);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().add(table);
        for (int i = 0; i < 5; i++) {
            table.addThread();
            //ths[i].setTable(table);
            //ths[i].start();
            table.changeState(i+1, 1);
        }

    }

}
