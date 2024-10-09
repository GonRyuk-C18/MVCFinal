package Repositories;

import Model.User;
import Tools.CsvLoginsReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> usersArray;


    public UserRepository() throws FileNotFoundException {
        this.usersArray = CsvLoginsReader.readCsvFileToLoginsArray("Files/Cesaeland_logins.csv");
    }

    public ArrayList<User> getUserArray() {
        return usersArray;
    }
}
