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

    MyCanvas(){
        this.setBackground(Color.WHITE);
        setImages();
        drawImg(10, 10, 10, 10, "0", Color.DARK_GRAY, toiletImg);
    }
    @Override
    public void paint(Graphics g){
        gAll = g.create();
    }
    private void drawImg(int x, int y, int w, int h, String text, Color color, BufferedImage image){
        gAll.setColor(color);
        gAll.drawString(text, x, y-1);
        gAll.drawImage(image, x, y, null);
    }
    private void setImages(){
        try {
            pistaImg = ImageIO.read(new File("./Assets/Toilet.png"));
            mechanicImg = ImageIO.read(new File("./Assets/Toilet.png"));
            runnerImg = ImageIO.read(new File("./Assets/Toilet.png"));
            viewerImg = ImageIO.read(new File("./Assets/Toilet.png"));
            gasStationImg = ImageIO.read(new File("./Assets/Toilet.png"));
            toiletImg = ImageIO.read(new File("./Assets/Toilet.png"));
            pitsImg = ImageIO.read(new File("./Assets/Toilet.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
