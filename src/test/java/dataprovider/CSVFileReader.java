package dataprovider;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.List;

public class CSVFileReader {

    public String[][] getCSVData(String filename, int row, int col) {
        String[][] data = new String[row][col];
        try {
            CSVReader csvreader = new CSVReader(new FileReader(filename));
            List<String[]> allRows = csvreader.readAll();
            for(int i = 0; i < allRows.size(); i++) {
                data[i] = allRows.get(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
