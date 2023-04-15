package Application.UseCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface IImages {

    BufferedImage readImages(File file) throws IOException;

}
