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

            /*for (int i = 0; i < row; i++) {
                String[] line = csvreader.readNext();
                for (int j = 0; j < line.length; j++) {
                    data[i][j] = line[j];
                }
            } */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
