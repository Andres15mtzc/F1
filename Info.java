import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info extends JFrame {

    public Info() {

        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        ImageIcon img = new ImageIcon("up.jpg");
        JLabel imgLabel = new JLabel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        imgLabel.setIcon(img);

        panel.add(imgLabel);
        panel.add(new JLabel("Universidad Panamericana"));
        panel.add(new JLabel("Ingeniería en Sistemas y Gráficas Computacionales"));
        panel.add(new JLabel("Fundamentos de Programación en Paralelo"));
        panel.add(new JLabel("Carlos Manuel Vélez - 0240599"));
        panel.add(new JLabel("Miguel Angel Tovar - 0213524"));
        panel.add(new JLabel("Andrés Martínez Cabrera - 0234500"));
        panel.add(new JLabel("Profesor: Juan Carlos Lopez Pimentel"));
        panel.add(new JLabel("28 de Noviembre 2023"));
        // this.getContentPane().add(imgPanel);

        this.getContentPane().add(panel);
        this.setVisible(true);
    }

}