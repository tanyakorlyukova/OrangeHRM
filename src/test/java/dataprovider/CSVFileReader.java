package dataprovider;

import com.opencsv.CSVReader;

import java.io.*;

public class CSVFileReader {

    public String[][] getCSVData(String filename, int row, int col) {
        String[][] data = new String[row][col];
        try {
            CSVReader csvreader = new CSVReader(new FileReader(filename));
            for (int i = 0; i < row; i++) {
                String[] line = csvreader.readNext();
                for (int j = 0; j < line.length; j++) {
                    data[i][j] = line[j];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
