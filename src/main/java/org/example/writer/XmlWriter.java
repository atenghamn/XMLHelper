package org.example.writer;

import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;

public interface XmlWriter {
    void write(Document document) throws TransformerException;
}
