package com.company.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonOutputFormatter {

    public void printToConsole(List<Map<String, String>> data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
            System.out.println(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
