package org.example.service;

import org.example.helper.XMLHelper;
import org.example.parser.DefaulXmlParserImplementation;
import org.example.parser.XmlParser;
import org.example.writer.DefaultXmlWriterImplementation;
import org.example.writer.XmlWriter;

public class DefaultXmlServiceImplementation implements XmlService {
    private final XmlWriter writer;
    private final XmlParser parser;

    public DefaultXmlServiceImplementation() {
        this.writer = new DefaultXmlWriterImplementation();
        this.parser = new DefaulXmlParserImplementation();
    }

    @Override
    public boolean getValueById(String filePath, String id) {
        XMLHelper helper = new XMLHelper(parser, writer);
        return helper.getTargetValueById(filePath, id);
    }
}
