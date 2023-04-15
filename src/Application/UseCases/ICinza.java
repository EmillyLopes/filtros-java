package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface ICinza {

    public void cinzaMedia(File img) throws IOException;

    public void cinzaBandaRed(File img) throws IOException;

    public void cinzaBandaGreen(File img) throws IOException;

    public void cinzaBandaBlue(File img) throws IOException;

}
