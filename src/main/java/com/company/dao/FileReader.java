package com.company.dao;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader {
    public List<Map<String, String>> readData(Path file) {
        List<Map<String, String>> csvData = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(file);
            CSVReader csvReader = new CSVReader(reader);

            String[] line;

            while ((line = csvReader.readNext()) != null) {

                Map<String, String> csvRow = new HashMap<>();
                for (int i = 0; i < line.length; i++) {
                    csvRow.put("col_" + i, line[i]);
                }
                csvData.add(csvRow);
            }
        } catch (IOException e) {
            System.out.println("Cannot read given file");
            e.printStackTrace();
            System.exit(0);
        }
        return csvData;
    }
}
