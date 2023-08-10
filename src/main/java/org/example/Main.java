package org.example;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        var filePath = "src/main/resources/sma_gentext.xml";
        var id = "42007";

        XMLHelper parser = new XMLHelper();
        var result = parser.getTargetValueById(filePath, id);
        System.out.println("Everything " + (result ? "went well" : "crashed and burned"));
    }
}