package com.unitedcoder.io;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XmlFileReadDemo {
    public static void main(String[] args) {
        System.out.println(readXmlFile("docs/readdoc.xml","2"));

    }
    public static String readXmlFile(String fileName, String id){
        String testInput=null;
        String projetPath=System.getProperty("user.dir");
        File fXmlFile= new File(projetPath+ File.separator+fileName);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder= null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc=null;
        try {
            doc=dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
        XPath xPath= XPathFactory.newInstance().newXPath();
        String expression=String.format("/TestCases/Test[@id='"+id+"']/Name");
        System.out.println(expression);
        Node node= null;
        try {
            node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
        testInput=node !=null ? (node.getTextContent()) :"cannot read the test case xml file";
        return testInput;
    }
}
