package com.checkr.interviews;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

public class CSVDataLoader {
  private String filePath;

  public CSVDataLoader(String filePath) {
    this.filePath = filePath;
  }

  public List<String[]> loadCSV() throws IOException {
    List<String[]> csvData = new ArrayList<>();
    CSVReader reader = new CSVReader(new FileReader(filePath));
    String[] row;
    while ((row = reader.readNext()) != null) {
      csvData.add(row);
    }
    reader.close();
    csvData.remove(0); // Remover o cabeçalho
    return csvData;
  }
}
