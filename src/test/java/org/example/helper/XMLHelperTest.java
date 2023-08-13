package org.example.helper;

import org.example.helper.XMLHelper;
import org.example.parser.DefaulXmlParserImplementation;
import org.example.parser.XmlParser;
import org.example.writer.DefaultXmlWriterImplementation;
import org.example.writer.XmlWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XMLHelperTest {
   XMLHelper helper;
    @BeforeEach
    public void SetUp(){
        XmlParser parser = new DefaulXmlParserImplementation();
        XmlWriter writer = new DefaultXmlWriterImplementation();
        helper = new XMLHelper(parser, writer);
    }
    @Test
    void testGetTargetValueById_whenGivenValidIdAndFile_ReturnTrue() {

        String filePath = "src/test/resources/sample.xml";
        String findId = "42007";

        boolean result = helper.getTargetValueById(filePath, findId);

        assertTrue(result);
    }

    @Test
    void testGetTargetValueById_whenGivenInvalidId_ReturnFalse() {
        String findId = "nonexistent_id";
        String filePath = "src/test/resources/invalid.xml";

        boolean result = helper.getTargetValueById(filePath, findId);

        assertFalse(result, "Expected extraction failure");
    }

}
