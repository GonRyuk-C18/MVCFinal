package Repositories;

import Model.Custo;
import Model.User;
import Tools.CsvCustosReader;
import Tools.CsvLoginsReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustosRepository {
    private ArrayList<Custo> custosArray;


    public CustosRepository() throws FileNotFoundException {
        this.custosArray = CsvCustosReader.readCsvFileToCustosArray("Files/Cesaeland_custos.csv");
    }

    public ArrayList<Custo> getCustoArray() {
        return custosArray;
    }
}
