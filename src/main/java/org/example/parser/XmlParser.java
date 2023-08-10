package org.example.parser;

import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public interface XmlParser {
    Document parser(File inputFile) throws ParserConfigurationException, org.xml.sax.SAXException, java.io.IOException;
}
