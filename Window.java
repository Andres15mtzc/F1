import javax.swing.JFrame;

public class Window extends JFrame {

    //private CriticalThread[] ths;
    private String[] ths;

    public Window(int width, int height, int n, String name, Table table) {
        this.setTitle(name);
        this.setVisible(true);
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().add(table);
        for (int i = 0; i < n; i++) {
            table.addAgent(i+1);
        }

    }

}
