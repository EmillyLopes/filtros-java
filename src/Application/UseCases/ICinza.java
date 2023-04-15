package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface ICinza {

    public void cinzaMedia(File img) throws IOException;

    public void cinzaRed(File img) throws IOException;

    public void cinzaGreen(File img) throws IOException;

    public void cinzaBlue(File img) throws IOException;

}
