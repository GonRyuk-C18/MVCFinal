package Repositories;

import Model.Venda;
import Tools.CsvVendasReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendasRepository {
    private ArrayList<Venda> vendasArray;


    public VendasRepository() throws FileNotFoundException {
        this.vendasArray = CsvVendasReader.readCsvFileToVendasArray("Files/Cesaeland_vendas.csv");

    }

    public ArrayList<Venda> getVendasArray() {
        return vendasArray;
    }
}
