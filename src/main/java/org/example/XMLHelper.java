package org.example;

import org.example.parser.XmlParser;
import org.example.writer.XmlWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class XMLHelper {
    private static final Logger logger = Logger.getLogger(XMLHelper.class.getName());

    private final XmlParser xmlParser;
    private final XmlWriter xmlWriter;

    public XMLHelper(XmlParser xmlParser, XmlWriter xmlWriter) {
        this.xmlParser = xmlParser;
        this.xmlWriter = xmlWriter;
    }

        public boolean getTargetValueById(String filePath, String findId) {
            try {
                File inputFile = new File(filePath);
                Document doc = xmlParser.parser(inputFile);
                doc.getDocumentElement().normalize();

                NodeList transUnitList = doc.getElementsByTagName("trans-unit");

                for (int temp = 0; temp < transUnitList.getLength(); temp++) {
                    Node transUnitNode = transUnitList.item(temp);
                    if (transUnitNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element transUnitElement = (Element) transUnitNode;
                        String id = transUnitElement.getAttribute("id");
                        if (id.equals(findId)) {
                            if (processTransUnitElement(transUnitElement)) {
                                logger.info(String.format("Successfully extracted target value for id %s and wrote it to file", findId));
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.warning(String.format("Failed to extract target value for id %s due to exception", findId));
            }
            logger.info(String.format("Failed to extract target value for id %s ", findId));
            return false;
        }

        private boolean processTransUnitElement(Element transUnitElement) throws Exception {
            NodeList targetList = transUnitElement.getElementsByTagName("target");
            if (targetList.getLength() > 0) {
                Element targetElement = (Element) targetList.item(0);
                String targetValue = targetElement.getTextContent();
                Document newDoc = createNewDocument(targetValue);
                xmlWriter.write(newDoc);
                return true;
            }
            return false;
        }

        private Document createNewDocument(String targetValue) throws ParserConfigurationException {
            DocumentBuilderFactory newDbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder newDbBuilder = newDbFactory.newDocumentBuilder();
            Document newDoc = newDbBuilder.newDocument();
            Element rootElement = newDoc.createElement("root");
            Element extrractedElement = newDoc.createElement("extracted-value");
            extrractedElement.setTextContent(targetValue);
            rootElement.appendChild(extrractedElement);
            newDoc.appendChild(rootElement);
            return newDoc;
        }
}
