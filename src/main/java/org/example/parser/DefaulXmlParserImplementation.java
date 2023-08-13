package org.example.parser;

import org.example.exceptions.XmlParserException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DefaulXmlParserImplementation implements XmlParser{
    @Override
    public Document parser(File inputFile) throws XmlParserException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(inputFile);
        } catch (ParserConfigurationException e) {
            throw new XmlParserException("Error configuring XML parser.", e);
        } catch (SAXException e) {
            throw new XmlParserException("Error parsing XML file.", e);
        } catch (IOException e) {
            throw new XmlParserException("Error reading XML file.", e);
        }
    }
}
