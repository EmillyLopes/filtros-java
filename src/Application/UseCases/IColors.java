package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface IColors {

    void bandaRed(File file) throws IOException;

    void bandaGreen(File file) throws IOException;

    void bandaBlue(File file) throws IOException;

    void aumentoTonalidade(File file, int opcao, int value, String cor) throws IOException;

}
