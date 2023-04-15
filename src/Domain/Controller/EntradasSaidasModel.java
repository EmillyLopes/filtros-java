package Domain.Controller;

import Domain.Service.FiltrosServices;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EntradasSaidasModel {

    public int menu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite :" +
                "\n1 - para o entrar no menu de bandas individuais RGB" +
                "\n2 - para entrar no menu Tons de cinza" +
                "\n3 - para entrar no menu de Brilho" +
                "\n4 - para entrar no menu Negativo" +
                "\n5 - Aumento de tonalidade" +
                "\n6 - Limiarização/binarização" +
                "\n7 - para realizar Conversão de RGB-YIQ-RGB" +
                "\n0 - Sair");
        int opcao = teclado.nextInt();
        return opcao;
    }

    public int menuRGB() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite :" +
                "\n1 - Red" +
                "\n2 - Green" +
                "\n3 - Blue" +
                "\n0 - Sair");
        int opcao =  teclado.nextInt();
        return opcao;
    }

    public int menuCinza(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite :" +
                "\n1 - Cinza Banda Média" +
                "\n2 - Cinza Banda Red" +
                "\n3 - Cinza Banda Green" +
                "\n4 - Cinza Banda Blue" +
                "\n0 - Sair");
        return teclado.nextInt();
    }

    public int menuBrilho(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite :" +
                "\n1 - Brilho Aditivo" +
                "\n2 - Brilho Multiplicativo " +
                "\n0 - Sair");
        return teclado.nextInt();
    }

    public int menuNegativo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite :" +
                "\n1 - Negativo" +
                "\n2 - Negativo em Y" +
                "\n0 - Sair");
        return teclado.nextInt();
    }

    public void verificaMenu(int opcao, File file) throws IOException {
        EntradasSaidasService service = new EntradasSaidasService();

        switch (opcao){
            case 1:
                int escolha = menuRGB();
                service.verificaRGB(escolha,file);
                break;
            case 2:
                escolha = menuCinza();
                service.verificaCinza(escolha,file);
                break;
            case 3:
                escolha = menuBrilho();
                service.verificaBrilho(escolha,file);
                break;
            case 4:
                escolha = menuNegativo();
                service.verificaNegativo(escolha,file);
                break;
            case 5:
                escolha = menuRGB();
                service.verificaAumentoTonalidade(escolha,file);
                break;
            case 6:
                service.verificaLimiarizacao(file);
                break;
            case 7:
                service.verificaConversao(file);
                break;
            case 0:
                System.exit(1);
        }
    }
}
