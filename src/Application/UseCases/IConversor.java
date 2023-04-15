package Application.UseCases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IConversor {

    public HashMap<String, ArrayList> conversaoRgbToYIQ(File img) throws IOException;

    public void conversaoYiqToRgb(File img, HashMap<String, ArrayList> yiq) throws IOException;

}
