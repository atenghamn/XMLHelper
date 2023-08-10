import org.example.XMLHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class XMLHelperTest {
    @Test
    void testGetTargetValueById_whenGivenValidIdAndFile_ReturnTrue() {
        XMLHelper helper = new XMLHelper();
        String filePath = "src/main/resources/sma_gentext.xml";
        String findId = "42007";

        boolean result = helper.getTargetValueById(filePath, findId);

        assertTrue(result);
    }

    @Test
    void testGetTargetValueById_whenGivenInvalidId_ReturnFalse() {
        XMLHelper helper = new XMLHelper();
        String findId = "nonexistent_id";
        String filePath = "src/main/resources/sma_gentext.xml";

        boolean result = helper.getTargetValueById(filePath, findId);

        assertFalse(result, "Expected extraction failure");
    }

}
