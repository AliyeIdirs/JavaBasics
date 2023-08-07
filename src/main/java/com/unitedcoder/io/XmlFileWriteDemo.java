package com.unitedcoder.io;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XmlFileWriteDemo {
    public static void main(String[] args) {
       String[] string=new String[]{"2", "Logout", "Inventory Module", "Regression Test", "Automated"};
        List<String> content=new ArrayList<>();
        Collections.addAll(content, string);

        createAXmlFile("docs","XmlTestWriter.xml",content);

    }
    public static void createAXmlFile(String fileFolder, String fileName, List<String> content){
        String workingDir= System.getProperty("user.dir");
        String filePath=workingDir+ File.separator+fileFolder+File.separator+fileName;
        try{
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();

            //root elements for test case
            Document doc=dBuilder.newDocument();
            Element rootElement=doc.createElement("TestCases");
            doc.appendChild(rootElement);

            //test elements
            Element test=doc.createElement("Test");
            rootElement.appendChild(test);

            //set attribute to test element
            Attr attribute=doc.createAttribute("id");
            attribute.setValue(content.get(0));
            test.setAttributeNode(attribute);

            //set Name element
            Element testName=doc.createElement("Name");
            testName.appendChild(doc.createTextNode(content.get(1)));
            test.appendChild(testName);

            //Test Module element
            Element testModule=doc.createElement("TestModule");
            testModule.appendChild(doc.createTextNode(content.get(2)));
            test.appendChild(testModule);

            //Test Type element
            Element testType=doc.createElement("TestType");
            testType.appendChild(doc.createTextNode(content.get(3)));
            test.appendChild(testType);

            //Test Execution element
            Element testExecution=doc.createElement("TestExecution");
            testExecution.appendChild(doc.createTextNode(content.get(4)));
            test.appendChild(testExecution);

            //write content into the xml file
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
            //enable indent(girinti) on the xml file
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");
            DOMSource source= new DOMSource(doc);
            StreamResult result=new StreamResult(new File(filePath));
            transformer.transform(source,result);
            System.out.println("File Saved!");


        } catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }catch(TransformerException tfe){
            tfe.printStackTrace();
        }
    }

}
