package org.example.parser;

import org.example.exceptions.XmlParserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlParserTest {
    private DefaulXmlParserImplementation xmlParser;

    @BeforeEach
    public void setUp() {
        xmlParser = new DefaulXmlParserImplementation();
    }

    @Test
    public void testParser() throws  XmlParserException {
        File inputFile = new File("src/test/resources/sample.xml");

        Document document = xmlParser.parser(inputFile);

        assertNotNull(document);
    }

    @Test
    public void testParserThrowsXmlParserExceptionOnSAXException() {
        File inputFile = new File("src/test/resources/invalid.xml");

        assertThrows(XmlParserException.class, () -> xmlParser.parser(inputFile));
    }

    @Test
    public void testParserThrowsXmlParserExceptionOnIOException() {
        File inputFile = new File("nonexistent.xml");

        assertThrows(XmlParserException.class, () -> xmlParser.parser(inputFile));
    }

}
