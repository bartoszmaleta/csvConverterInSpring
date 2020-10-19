package com.company.service;


import com.company.model.OutputFormat;
import com.company.dao.FileReader;
import com.company.factory.OutputFormatterFactory;
import com.company.view.OutputFormatter;
import com.github.aneureka.exception.FieldsNotSetException;
import com.github.aneureka.exception.RowSizeMismatchException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class SimpleCsvConverter {

    private final FileReader fileReader;
    private final OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(Path file) throws FieldsNotSetException, RowSizeMismatchException {
        OutputFormat outputFormat = OutputFormat.TABLE;

        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.printf("I convert CSV to %s%n", outputFormat);
        outputFormatter.printToConsole(this.fileReader.readData(file));
    }

    public void convert(Path file, OutputFormat outputFormat) throws FieldsNotSetException, RowSizeMismatchException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.println(String.format("I convert CSV to %s", outputFormat));
        outputFormatter.printToConsole(this.fileReader.readData(file));
    }
}
