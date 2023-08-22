package com.unitedcoder.io;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class HtmlFileReadDemo {
    public static void main(String[] args) {
        //get current project path
        String projectPath = System.getProperty("user.dir");
        //get file separator
        String fileSeparator = File.separator;
        //get file path
        String filePath = projectPath + fileSeparator;
        //get the html file to parse its content
        File htmlFile = new File(filePath + "docs/testfile.html");
        try {
            //parse the html file
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            //get all table cell elements
            Elements tableRows = doc.getElementsByTag("tr");
            //print headers
            for (Element row : tableRows) {
                Elements tableHeaders = row.getElementsByTag("th");
                for (Element element : tableHeaders) {
                    //get text content of each cell element
                    String elementText = element.text();
                    //print out the content
                    System.out.print(elementText + " ");
                }

            }
            //get each row to content without header
            for (Element row : tableRows) {
                Elements tableCells = row.getElementsByTag("td");
                //iterate over each element
                for (Element element : tableCells) {
                    //get text content of each cell element
                    String elementText = element.text();
                    //print out the content
                    System.out.print(elementText + " ");

                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
