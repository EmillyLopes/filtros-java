package Application.UseCases;

import java.io.File;
import java.io.IOException;

public interface IFiltro {

    public void negativo(File img) throws IOException;

    public void limiarizacao(File img, int limiar) throws IOException;

}
