package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface IConversor {

    public void conversaoYIQToRGB(File img) throws IOException ;

    public void conversaoRGBToYIQ(File img) throws IOException ;

}
