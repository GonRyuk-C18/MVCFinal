package Tools;


import Model.Custo;
import Model.Venda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvCustosReader {

    public static ArrayList<Custo> readCsvFileToCustosArray(String filePath) throws FileNotFoundException {

        // Instanciar o ArrayList de Vendas
        ArrayList<Custo> custosArray = new ArrayList<>();

        // Abrir o ficheiro e criar o Scanner
        File custosFiles = new File(filePath);
        Scanner custosScanner = new Scanner(custosFiles);

        // Avançar o cabeçalho à frente
        custosScanner.nextLine();

        // Ciclo vai correr para cada linha (venda) do ficheiro
        while (custosScanner.hasNextLine()) {
            // Capturar a linha atual
            String linhaAtual = custosScanner.nextLine();

            // Dividir a linha atual para um array de Strings
            String[] linhaDividida = linhaAtual.split(";");

            // Criar variáveis locais para cada parâmetro de uma venda
            int idAtracao = Integer.parseInt(linhaDividida[0]);
            double custoManutencao = Double.parseDouble(linhaDividida[1]);
            int custoFixoMes = Integer.parseInt(linhaDividida[2]);

            // Criamos a venda atual
            Custo custoAtual = new Custo(idAtracao,custoManutencao,custoFixoMes);

            // Adicionamos a venda atual ao ArrayList
            custosArray.add(custoAtual);
        }

        // Depois de terminar o ciclo, e termos o ArrayList com todas a vendas, retornamos o mesmo
        return custosArray;
    }
}