package Domain.Service;

import Application.UseCases.IConversor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConversaoService {

    public HashMap<String, ArrayList> conversaoRgbToYIQ(File img) throws IOException {
        BufferedImage image = ImageIO.read(img);
        HashMap<String, ArrayList> yiq = new HashMap<>();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                String key = String.valueOf(x) + "," + String.valueOf(y);
                yiq.put(key, new ArrayList<>());

                Color color = new Color(image.getRGB(x, y));

                double Y = color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() * 0.114;
                double I = color.getRed() * 0.596 + color.getGreen() * -0.274 + color.getBlue() * -0.322;
                double Q = color.getRed() * 0.211 + color.getGreen() * -0.523 + color.getBlue() * 0.312;

                yiq.get(key).add(Y);
                yiq.get(key).add(I);
                yiq.get(key).add(Q);

            }
        }
        return yiq;
    }

    public void conversaoYiqToRgb(File img, HashMap<String, ArrayList> yiq) throws IOException {
        BufferedImage image = ImageIO.read(img);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                String key = String.valueOf(x) + "," + String.valueOf(y);

                Double t = (Double) yiq.get(key).get(0);

                int r = (int) Math.min(255, Math.max(0,
                        1.000 * (Double) yiq.get(key).get(0) +
                                0.956 * (Double) yiq.get(key).get(1) +
                                0.621 * (Double) yiq.get(key).get(2)
                ));

                int g = (int) Math.min(255, Math.max(0,
                        1.000 * (Double) yiq.get(key).get(0) +
                                -0.272 * (Double) yiq.get(key).get(1) +
                                -0.647 * (Double) yiq.get(key).get(2)
                ));

                int b = (int) Math.min(255, Math.max(0,
                        1.000 * (Double) yiq.get(key).get(0) +
                                -1.106 * (Double) yiq.get(key).get(1) +
                                1.703 * (Double) yiq.get(key).get(2)
                ));

                Color newColor = new Color(r, g, b);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

        ImageIO.write(image, "jpg", new File("yiqToRgb" + ".jpg"));
    }

}
