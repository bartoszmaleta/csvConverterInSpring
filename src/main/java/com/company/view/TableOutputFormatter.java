package com.company.view;

import com.github.aneureka.exception.FieldsNotSetException;
import com.github.aneureka.exception.RowSizeMismatchException;
import com.github.aneureka.util.PrettyTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TableOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String, String>> data) throws FieldsNotSetException, RowSizeMismatchException {
        List<String> headers = Arrays.asList(data.get(0).keySet().toArray(new String[data.get(0).keySet().size()]));

        PrettyTable prettyTable = new PrettyTable(headers);

        for (int i = 0; i < data.size(); i++) {
            List<String> valueList = new ArrayList<>();

            String[] keyArray = data.get(i).keySet().toArray(new String[data.get(i).keySet().size()]);

            for (int j = 0; j < keyArray.length; i++) {
                valueList.add(data.get(i).get(keyArray[j]));
            }
            String[] temp = new String[valueList.size()];
            temp = valueList.toArray(temp);
            prettyTable.addRow(Arrays.asList(temp));
        }
        System.out.println(prettyTable);
    }
}
