package Main;

import Domain.Controller.EntradasSaidasModel;

import java.io.File;
import java.io.IOException;

public class FiltroApplication {

    public static void main(String[] args) throws IOException {

        File file = new File("src/resources/foto.jpeg");

        EntradasSaidasModel model = new EntradasSaidasModel();

        int opcao = model.menu();
        model.verificaMenu(opcao,file);


    }

}
