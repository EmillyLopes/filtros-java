package Domain.Service;

import Application.UseCases.IColors;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorsService implements IColors {

    ImagesService imagesService = new ImagesService();

    @Override
    public void bandaRed(File file) throws IOException {
        BufferedImage image = imagesService.readImages(file);

        // Percorra os pixels da imagem
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Obtenha a cor do pixel atual
                Color color = new Color(image.getRGB(x, y));
                // Remova as bandas verde e azul, mantendo a vermelha
                Color newColor = new Color(color.getRed(), 0, 0);
                // Aplique a nova cor ao pixel
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(image, "jpg", new File("src/resources/bandaR.jpg"));
    }

    @Override
    public void bandaGreen(File file) throws IOException {
        BufferedImage image = imagesService.readImages(file);
        // Percorra os pixels da imagem
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Obtenha a cor do pixel atual
                Color color = new Color(image.getRGB(x, y));
                // Remova as bandas verde e azul, mantendo a vermelha
                Color newColor = new Color(0, color.getGreen(), 0);
                // Aplique a nova cor ao pixel
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(image, "jpg", new File("src/resources/bandaG.jpg"));
    }

    @Override
    public void bandaBlue(File file) throws IOException {
        BufferedImage image = imagesService.readImages(file);
        // Percorra os pixels da imagem
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Obtenha a cor do pixel atual
                Color color = new Color(image.getRGB(x, y));
                // Remova as bandas verde e azul, mantendo a vermelha
                Color newColor = new Color(0, 0, color.getBlue());
                // Aplique a nova cor ao pixel
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(image, "jpg", new File("src/resources/bandaB.jpg"));
    }

    @Override
    public void aumentoTonalidade(File file, int opcao, int value) throws IOException {
        BufferedImage image = imagesService.readImages(file);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                switch (opcao){
                    case 1:
                        r = Math.min(255, Math.max(0, r + value));
                        break;
                    case 2:
                        g = Math.min(255, Math.max(0, g + value));
                        break;
                    case 3:
                        b = Math.min(255, Math.max(0, b + value));
                        break;
                }

                Color newColor = new Color(r, g, b);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("src/resources/aumentoTon_" + 1 + ".jpg"));
    }

}