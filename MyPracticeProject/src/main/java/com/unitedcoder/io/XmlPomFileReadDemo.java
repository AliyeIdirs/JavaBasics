package com.unitedcoder.io;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlPomFileReadDemo {
        public static void main(String[] args) throws IOException, XmlPullParserException {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            System.out.println(model.getId());
            System.out.println(model.getGroupId());
            System.out.println(model.getArtifactId());
            System.out.println(model.getVersion());

    }
    public static String readPomFile(String fileName, String artifactId){
        String testInput="";
        String projectPath= System.getProperty("user.dir");
        File fXmlFile=new File(projectPath+File.separator+fileName);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder=null;
        try{
            dBuilder=dbFactory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        Document doc=null;
        try {
           doc=dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
        XPath xPath= XPathFactory.newInstance().newXPath();
        String expression=String.format("/dependencies/dependency/[@artifactId='"+artifactId+"']/version");
        System.out.println(expression);
        Node node=null;
        try {
             node=(Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
       if(node!=null){
           testInput=node.getTextContent();
       }else{
           System.out.println("cannot read the pom.xml file");
       }
       return testInput;
    }
}
