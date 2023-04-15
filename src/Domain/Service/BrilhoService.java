package Domain.Service;

import Application.UseCases.IBrilho;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BrilhoService implements IBrilho {

    public void brilhoAdd(File img, int value) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = Math.min(255, Math.max(0, r + value));
                g = Math.min(255, Math.max(0, g + value));
                b = Math.min(255, Math.max(0, b + value));

                Color newColor = new Color(r, g, b);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/brilhoAdd" + ".jpg"));
    }

    public void brilhoMtt(File img, float value) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = (int) Math.min(255, Math.max(0, r * value));
                g = (int) Math.min(255, Math.max(0, g * value));
                b = (int) Math.min(255, Math.max(0, b * value));

                Color newColor = new Color(r, g, b);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/brilhoMtt" + ".jpg"));
    }

}
