package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface IBrilho {

    void brilhoAdd(File img, int value) throws IOException;

    void brilhoMtt(File img, float value) throws IOException;

}
