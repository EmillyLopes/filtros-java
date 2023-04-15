package Domain.Controller;

import Domain.Service.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EntradasSaidasService  {

    ColorsService colorsService = new ColorsService();
    CinzaService cinzaService = new CinzaService();
    BrilhoService brilhoService = new BrilhoService();
    FiltrosServices filtrosServices = new FiltrosServices();
    ConversaoService conversaoService = new ConversaoService();

    public void verificaRGB(int opcao, File file) throws IOException {
        switch(opcao){
            case 1:
                colorsService.bandaRed(file);
                break;
            case 2:
                colorsService.bandaGreen(file);
                break;
            case 3:
                colorsService.bandaBlue(file);
                break;
            case 0:
                System.exit(1);
        }
    }
    public void verificaAumentoTonalidade(int opcao, File file) throws IOException {
        int valorAumentado = valorInt();
        String cor = " ";
        if(opcao == 1){
            cor = "red";
        }if( opcao == 2){
            cor = "green";
        }if(opcao == 3){
            cor = "blue";
        }
        colorsService.aumentoTonalidade(file,opcao,valorAumentado, cor);
    }
    public void verificaCinza(int opcao, File file) throws IOException {
        switch(opcao){
            case 1:
                cinzaService.cinzaMedia(file);
                break;
            case 2:
                cinzaService.cinzaRed(file);
                break;
            case 4:
                cinzaService.cinzaGreen(file);
                break;
            case 3:
                cinzaService.cinzaBlue(file);
                break;
            case 0:
                System.exit(1);
        }
    }
    public void verificaBrilho(int opcao, File file) throws IOException {
        switch(opcao){
            case 1:
                int valor = valorInt();
                brilhoService.brilhoAdd(file,valor);
                break;
            case 2:
                float valorF = valorFloat();
                brilhoService.brilhoMtt(file,valorF);
                break;
            case 0:
                System.exit(1);
        }
    }
    public void verificaNegativo(int opcao, File file) throws IOException {
        switch(opcao){
            case 1:
                filtrosServices.negativo(file);
                break;
            case 2:
                filtrosServices.negativoY(file);
                break;
            case 0:
                System.exit(1);
        }
    }

    public void verificaLimiarizacao(File file) throws IOException {
        int valorAumentado = valorInt();
        filtrosServices.limiarizacao(file,valorAumentado);
    }

    public void verificaConversao(File file) throws IOException {
        HashMap<String, ArrayList> yiq =  conversaoService.conversaoRgbToYIQ(file);
        conversaoService.conversaoYiqToRgb(file,yiq);

    }

    public int valorInt(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor o qual deseja aumentar : ");
        return teclado.nextInt();
    }
    public float valorFloat(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor o qual deseja aumentar : ");
        return teclado.nextFloat();
    }
}
