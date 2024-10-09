package Repositories;

import Model.Atracao;
import Tools.CsvAtracoesReader;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AtracoesRepository {
    private ArrayList<Atracao> atracoesArray;


    public AtracoesRepository() throws FileNotFoundException {
        this.atracoesArray = CsvAtracoesReader.readCsvFileToAtracoesArray("Files/Cesaeland_atracoes.csv");
    }

    public ArrayList<Atracao> getAtracaoArray() {
        return atracoesArray;
    }
}
