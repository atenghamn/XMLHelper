package org.example;
import org.example.service.DefaultXmlServiceImplementation;
public class Main {

    public static void main(String[] args) {
        var filePath = "src/main/resources/sma_gentext.xml";
        var id = "42007";

        var result = new DefaultXmlServiceImplementation().getValueById(filePath, id);
        System.out.println("Everything " + (result ? "went well" : "crashed and burned"));
    }
}