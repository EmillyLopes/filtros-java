package Domain.Service;

import Application.UseCases.IImages;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagesService implements IImages {

    @Override
    public BufferedImage readImages(File file) throws IOException {
        return ImageIO.read(file);
    }

}
