package org.example.writer;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DefaultXmlWriterImplementation implements XmlWriter{

    @Override
    public void write(Document document) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(new File("src/main/java/org/example/generatedDocuments/extracted.xml"));
        transformer.transform(source, result);
    }
}
