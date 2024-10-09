package Tools;


import Model.Venda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvVendasReader {

    public static ArrayList<Venda> readCsvFileToVendasArray(String filePath) throws FileNotFoundException {

        // Instanciar o ArrayList de Vendas
        ArrayList<Venda> vendasArray = new ArrayList<>();

        // Abrir o ficheiro e criar o Scanner
        File vendasFiles = new File(filePath);
        Scanner vendasScanner = new Scanner(vendasFiles);

        // Avançar o cabeçalho à frente
        vendasScanner.nextLine();

        // Ciclo vai correr para cada linha (venda) do ficheiro
        while (vendasScanner.hasNextLine()) {
            // Capturar a linha atual
            String linhaAtual = vendasScanner.nextLine();

            // Dividir a linha atual para um array de Strings
            String[] linhaDividida = linhaAtual.split(";");

            // Criar variáveis locais para cada parâmetro de uma venda
            int idAtracao = Integer.parseInt(linhaDividida[0]);
            String dataMes = linhaDividida[1];
            String clienteTipo = linhaDividida[2];

            // Criamos a venda atual
            Venda vendaAtual = new Venda(idAtracao,dataMes,clienteTipo);

            // Adicionamos a venda atual ao ArrayList
            vendasArray.add(vendaAtual);
        }

        // Depois de terminar o ciclo, e termos o ArrayList com todas a vendas, retornamos o mesmo
        return vendasArray;
    }
}