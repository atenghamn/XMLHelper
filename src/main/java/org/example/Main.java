package org.example;

import org.example.parser.DefaulXmlParserImplementation;
import org.example.parser.XmlParser;
import org.example.writer.DefaultXmlWriterImplementation;
import org.example.writer.XmlWriter;

import javax.sql.rowset.spi.XmlReader;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        var filePath = "src/main/resources/sma_gentext.xml";
        var id = "42007";

        XmlWriter writer = new DefaultXmlWriterImplementation();
        XmlParser parser = new DefaulXmlParserImplementation();

        XMLHelper helper = new XMLHelper(parser, writer);
        var result = helper.getTargetValueById(filePath, id);
        System.out.println("Everything " + (result ? "went well" : "crashed and burned"));
    }
}