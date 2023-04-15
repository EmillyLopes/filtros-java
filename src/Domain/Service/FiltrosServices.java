package Domain.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiltrosServices {

    public void negativo(File img) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                int r = Math.max(0, 255 - color.getRed());
                int g = Math.max(0, 255 - color.getGreen());
                int b = Math.max(0, 255 - color.getBlue());

                Color newColor = new Color(r, g, b);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/negativo.jpg"));
    }
    public void negativoY(File img) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                int r = Math.max(0, 255 - color.getRed());
                int g = Math.max(0, 255 - color.getGreen());
                int b = Math.max(0, 255 - color.getBlue());

                Color newColor = new Color(r, g, b);
                image.setRGB(x, image.getHeight() - y - 1, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/negativoY.jpg"));
    }

    public void limiarizacao(File img, int limiar) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Get the color of the current pixel
                Color color = new Color(image.getRGB(x, y));

                // Calculate the average of the red, green, and blue channels
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                boolean isLargerThanLimiar = average > limiar;

                // Create a new grayscale color using the average value
                Color newColor;
                if(isLargerThanLimiar) {
                    newColor = new Color(255, 255, 255);
                } else {
                    newColor = new Color(0, 0, 0);
                }

                // Set the new color to the pixel
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/limiarizacao.jpg"));
    }

}

