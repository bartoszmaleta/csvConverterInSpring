package com.company;

import com.company.converter.SimpleCsvConverter;
import com.company.model.OutputFormat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterApplication {
    public static void main(String[] args) {
        if (args.length == 0) System.out.println("No args provided.");

        int PATH_ARG_INDEX = args.length - 1;
        Path file = Paths.get(args[PATH_ARG_INDEX]);

        // TODO: Spring framework
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleCsvConverter simpleCsvConverter = (SimpleCsvConverter) ctx.getBean("simpleCsvConverter");

        if (args.length == 1) {
            simpleCsvConverter.convert(file);
        } else {
            OutputFormat outputFormat = null;
            int FORMAT_ARG_INDEX = 0;

            if (args[FORMAT_ARG_INDEX].equals("json")) {
                outputFormat = OutputFormat.JSON;
            } else if (args[FORMAT_ARG_INDEX].equals("xml")) {
                outputFormat = OutputFormat.XML;
            } else {
                System.out.println("No such output format defined");
                System.exit(0);
            }
            simpleCsvConverter.convert(file, outputFormat);
        }
    }
}
