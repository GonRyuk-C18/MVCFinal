package Tools;


import Model.Atracao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvAtracoesReader {

    public static ArrayList<Atracao> readCsvFileToAtracoesArray(String filePath) throws FileNotFoundException {

        // Instanciar o ArrayList de Vendas
        ArrayList<Atracao> atracoesArray = new ArrayList<>();

        // Abrir o ficheiro e criar o Scanner
        File atracoesFiles = new File(filePath);
        Scanner atracoesScanner = new Scanner(atracoesFiles);

        // Avançar o cabeçalho à frente
        atracoesScanner.nextLine();

        // Ciclo vai correr para cada linha (venda) do ficheiro
        while (atracoesScanner.hasNextLine()) {
            // Capturar a linha atual
            String linhaAtual = atracoesScanner.nextLine();

            // Dividir a linha atual para um array de Strings
            String[] linhaDividida = linhaAtual.split(";");

            // Criar variáveis locais para cada parâmetro de uma venda
            int id = Integer.parseInt(linhaDividida[0]);
            String nome = linhaDividida[1];
            double precoAdulto = Double.parseDouble(linhaDividida[2]);
            double precoCrianca = Double.parseDouble(linhaDividida[3]);
            int segundos = Integer.parseInt(linhaDividida[4]);

            // Criamos a venda atual
            Atracao atracaoAtual = new Atracao(id,nome,precoAdulto,precoCrianca,segundos);

            // Adicionamos a venda atual ao ArrayList
            atracoesArray.add(atracaoAtual);
        }

        // Depois de terminar o ciclo, e termos o ArrayList com todas a vendas, retornamos o mesmo
        return atracoesArray;
    }
}