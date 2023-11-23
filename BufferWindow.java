import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BufferWindow extends JFrame{
    public BufferWindow(){
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JLabel("BUFFER MANAGER"));
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel("Pits: 2/2 available"));
        panel.add(new JLabel(" "));
        panel.add(new JLabel("Gas Station: 1/1 available"));
        panel.add(new JLabel(" "));
        panel.add(new JLabel("Restrooms: 4/4 available"));

        this.getContentPane().add(panel);
    }
}
