import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Table extends JPanel {

    private int cols;
    private ArrayList<JPanel> panels;
    private ArrayList<JLabel> panelTexts;
    private ArrayList<JLabel> accesses;
    private JLabel[] labels;

    private String name;

    public Table(String name, String[] labelsNames) {
        this.cols = labelsNames.length;
        this.name = name;

        GridLayout grid = new GridLayout(0, this.cols);
        this.setLayout(grid);

        panels = new ArrayList<JPanel>();
        panelTexts = new ArrayList<JLabel>();
        labels = new JLabel[this.cols];
        accesses = new ArrayList<JLabel>();

        panelTexts.add(new JLabel(""));

        for (int i = 0; i < this.cols; i++) {
            panels.add(new JPanel());
            panels.get(panels.size() - 1).setBackground(Color.WHITE);
            panels.get(i).setBorder(new LineBorder(Color.BLACK));
            panels.get(i).setVisible(true);
            panelTexts.add(new JLabel());
            this.add(panels.get(i));
        }

        for (int i = 0; i < this.cols; i++) {
            labels[i] = new JLabel(labelsNames[i]);
            panels.get(i).add(labels[i]);
        }

        this.setVisible(true);

    }

    // public void addThread() { // ---------------- parámetro borrado
    public void addAgent(int n) {
        int nPanels = panels.size();
        for (int i = 0; i < this.cols; i++) {
            panels.add(new JPanel());
            panels.get(panels.size() - 1).setBorder(new LineBorder(Color.BLACK));
            panels.get(panels.size() - 1).setBackground(Color.WHITE);
            panelTexts.add(new JLabel(""));
            panels.get(panels.size() - 1).add(panelTexts.get(panelTexts.size() - 1));
            this.add(panels.get(panels.size() - 1));
        }

        panels.get(nPanels).add(new JLabel(name + " " + n));

        // panels.get(nPanels + 1).add(new JLabel(thread.getName()));
        // panels.get(nPanels + 1).add(new JLabel(""));
        accesses.add(new JLabel(""));
        panels.get(nPanels + 1).add(accesses.get(accesses.size() - 1));
    }

    public void changeState(int row, int col) {
        for (int i = 0; i < this.cols; i++) {
            panels.get(i + this.cols * row).setBackground(Color.WHITE);
        }
        panels.get(row * this.cols + col).setBackground(Color.GREEN);
    }

    public void changeState(int row, int col, Color color) {
        for (int i = 0; i < this.cols; i++) {
            panels.get(i + this.cols * row).setBackground(Color.WHITE);
        }
        panels.get(row * this.cols + col).setBackground(color);
    }

    public void changeState(int row, String val) {
        accesses.get(row).setText(val);
    }

    public void changeState(int row, int col, String val) {
        panelTexts.get(row * this.cols + (col + 1)).setText(val);
    }

    public String getName() {
        return name;
    }

}
