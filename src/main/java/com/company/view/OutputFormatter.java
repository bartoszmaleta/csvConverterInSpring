package com.company.view;

import com.github.aneureka.exception.FieldsNotSetException;
import com.github.aneureka.exception.RowSizeMismatchException;

import java.util.List;
import java.util.Map;

public interface OutputFormatter {
    void printToConsole(List<Map<String, String>> data) throws FieldsNotSetException, RowSizeMismatchException;
}
