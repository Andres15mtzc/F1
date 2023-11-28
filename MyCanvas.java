import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MyCanvas extends Canvas {
    private Graphics gAll;
    Thread t;
    boolean shooted = false;
    BufferedImage pistaImg, mechanicImg, runnerImg, viewerImg, gasStationImg, toiletImg, pitsImg;
    Race race;

    MyCanvas(Race race) {
        this.race = race;
        this.setBackground(Color.WHITE);
        setImages();
    }

    @Override
    public void paint(Graphics g) {
        gAll = g.create();
        drawScreen();
    }

    public void drawScreen() {
        gAll.setColor(Color.WHITE);
        gAll.fillRect(0, 0, 1200, 800);
        drawImg(350, 50, 500, 500, "", Color.DARK_GRAY, pistaImg);
        drawImg(10, 600, 100, 100, "", Color.DARK_GRAY, toiletImg);
        drawImg(1000, 50, 100, 100, "", Color.DARK_GRAY, gasStationImg);
        drawImg(1000, 600, 100, 100, "", Color.DARK_GRAY, pitsImg);
        drawImg(80, 200, 100, 100, String.valueOf(race.noViewersWatch), Color.DARK_GRAY, viewerImg);
        drawImg(130, 600, 100, 100, String.valueOf(race.noViewersPee), Color.DARK_GRAY, viewerImg);
        drawImg(600, 200, 100, 100, String.valueOf(race.noRunnersRun), Color.DARK_GRAY, runnerImg);
        drawImg(1000, 200, 100, 100, String.valueOf(race.noRunnersGas), Color.DARK_GRAY, runnerImg);
        drawImg(1000, 500, 100, 100, String.valueOf(race.noRunnersPits), Color.DARK_GRAY, runnerImg);
        drawImg(850, 600, 100, 100, String.valueOf(race.noMechanicsWork), Color.DARK_GRAY, mechanicImg);
        drawImg(500, 600, 100, 100, String.valueOf(race.noMechanicsWait), Color.DARK_GRAY, mechanicImg);
    }

    private void drawImg(int x, int y, int w, int h, String text, Color color, BufferedImage image) {
        gAll.setColor(color);
        gAll.drawString(text, x + w / 2, y - 1);
        gAll.drawImage(image, x, y, w, h, null);
    }

    private void setImages() {
        try {
            pistaImg = ImageIO.read(new File("./Assets/track.jpg"));
            mechanicImg = ImageIO.read(new File("./Assets/Mechanic.png"));
            runnerImg = ImageIO.read(new File("./Assets/F1Symbol.png"));
            viewerImg = ImageIO.read(new File("./Assets/Viewer.png"));
            gasStationImg = ImageIO.read(new File("./Assets/GasPump.png"));
            toiletImg = ImageIO.read(new File("./Assets/Toilet.png"));
            pitsImg = ImageIO.read(new File("./Assets/PitStop.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
