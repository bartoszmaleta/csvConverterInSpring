package com.company.converter;


import com.company.model.OutputFormat;
import com.company.dao.FileReader;
import com.company.factory.OutputFormatterFactory;
import com.company.view.OutputFormatter;

import java.nio.file.Path;

public class SimpleCsvConverter {

    private final FileReader fileReader;
    private final OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(Path file) {
        OutputFormat outputFormat = OutputFormat.TABLE;

        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.printf("I convert CSV to %s%n", outputFormat);
        outputFormatter.printToConsole(this.fileReader.readData(file));
    }

    public void convert(Path file, OutputFormat outputFormat) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.println(String.format("I convert CSV to %s", outputFormat));
        outputFormatter.printToConsole(this.fileReader.readData(file));
    }
}
