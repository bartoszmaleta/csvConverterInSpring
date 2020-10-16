package com.company.view;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.NamedMapConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String, String>> data) {
        XStream xStream = new XStream();
        xStream.alias("csv  data", List.class);
        xStream.alias("row", HashMap.class);
        NamedMapConverter namedMapConverter = new NamedMapConverter(xStream.getMapper()
                , "data"
                , "key"
                , String.class
                , "value"
                , String.class
                , true
                , true
                , xStream.getConverterLookup());
        xStream.registerConverter(namedMapConverter);
        String xmlResult = xStream.toXML(data);
        System.out.println(xmlResult);
    }
}
