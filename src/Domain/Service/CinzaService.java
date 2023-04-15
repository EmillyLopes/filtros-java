package Domain.Service;

import Application.UseCases.ICinza;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CinzaService implements ICinza {

    public void cinzaMedia(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));

                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                Color newColor = new Color(average, average, average);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(image, "jpg", new File("src/resources/cinza_media.jpg"));
    }

    public void cinzaRed(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color corOriginal = new Color(image.getRGB(x, y));

                int vermelho = corOriginal.getRed();

                Color corCinza = new Color(vermelho, vermelho, vermelho);
                image.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(image, "png",new File("src/resources/cinza_red.png" ));
    }

    public void cinzaGreen(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color corOriginal = new Color(image.getRGB(x, y));

                int verde = corOriginal.getGreen();
                Color corCinza = new Color(verde, verde, verde);
                image.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(image,"png",new File("src/resources/cinza_green.png" ));
    }

    public void cinzaBlue(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color corOriginal = new Color(image.getRGB(x, y));

                int azul = corOriginal.getBlue();
                Color corCinza = new Color(azul, azul, azul);
                image.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(image,"png",new File("src/resources/cinza_blue.png" ));
    }

}

