package com.company.factory;

import com.company.model.OutputFormat;
import com.company.view.OutputFormatter;
import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) {
        switch (outputFormat) {
            case JSON:
//                return new JsonOutputFormatter();
            case XML:
//                return new XmlOutputFormatter();
            case TABLE:
//                return new TableOutputFormatter();
            default:
                throw new IllegalArgumentException();
        }
    }
}
