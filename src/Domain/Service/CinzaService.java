package Domain.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CinzaService {

    public void cinzaMedia(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        // Loop through the pixels of the image
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Get the color of the current pixel
                Color color = new Color(image.getRGB(x, y));

                // Calculate the average of the red, green, and blue channels
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                // Create a new grayscale color using the average value
                Color newColor = new Color(average, average, average);

                // Set the new color to the pixel
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/grayScale.jpg"));
    }

    public void cinzaRed(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        // cria uma nova imagem em nível de cinza
        BufferedImage imagemCinza = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // percorre cada pixel da imagem original e converte para nível de cinza
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // obtém a cor do pixel em RGB
                Color corOriginal = new Color(image.getRGB(x, y));

                // calcula a média dos valores de R, G e B para obter o tom de cinza
                int cinza = (int) (corOriginal.getRed() * 0.299 + corOriginal.getGreen() * 0.587 + corOriginal.getBlue() * 0.114);

                // cria um novo objeto Color com a média dos valores de R, G e B para o componente de vermelho
                Color corCinza = new Color(cinza, cinza, cinza);

                // define a nova cor do pixel na nova imagem em nível de cinza
                imagemCinza.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(imagemCinza, "png",new File("src/resources/imagem_cinza.png" ));
    }

    public void cinzaGreen(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        // cria uma nova imagem em nível de cinza
        BufferedImage imagemCinza = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // percorre cada pixel da imagem original e converte para nível de cinza
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // obtém a cor do pixel em RGB
                Color corOriginal = new Color(image.getRGB(x, y));

                // calcula a média dos valores de R, G e B para obter o tom de cinza
                int cinza = (int) (corOriginal.getRed() * 0.299 + corOriginal.getGreen() * 0.587 + corOriginal.getBlue() * 0.114);

                // cria um novo objeto Color com a média dos valores de R, G e B para o componente de vermelho
                Color corCinza = new Color(cinza, cinza, cinza);

                // define a nova cor do pixel na nova imagem em nível de cinza
                imagemCinza.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(imagemCinza, "png",new File("src/resources/imagem_cinza_.png" ));
    }

    public void cinzaBlue(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        // cria uma nova imagem em nível de cinza
        BufferedImage imagemCinza = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // percorre cada pixel da imagem original e converte para nível de cinza
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // obtém a cor do pixel em RGB
                Color corOriginal = new Color(image.getRGB(x, y));

                // calcula a média dos valores de R, G e B para obter o tom de cinza
                int cinza = (int) (corOriginal.getRed() * 0.299 + corOriginal.getGreen() * 0.587 + corOriginal.getBlue() * 0.114);

                // cria um novo objeto Color com a média dos valores de R, G e B para o componente de vermelho
                Color corCinza = new Color(cinza, cinza, cinza);

                // define a nova cor do pixel na nova imagem em nível de cinza
                imagemCinza.setRGB(x, y, corCinza.getRGB());
            }
        }
        ImageIO.write(imagemCinza,"png",new File("src/resources/imagem_cinza.png" ));
    }
}

