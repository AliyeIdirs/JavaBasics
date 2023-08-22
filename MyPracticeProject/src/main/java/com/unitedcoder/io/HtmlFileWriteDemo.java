package com.unitedcoder.io;

import java.io.*;

public class HtmlFileWriteDemo {
    public static StringBuilder htmlStringReport;

    public static void main(String[] args) {
        try {
            //define a HTML String Builder
            htmlStringReport = new StringBuilder();
            //append html header and title
            htmlStringReport.append("<html><head><title>Selenium Test </title></head>");
            //append body
            htmlStringReport.append("<body>");
            //append table
            htmlStringReport.append("<table border=\"1\" bordercolor=\"#000000\">");
            //append row
            addRowToHtmlReport("Test Id", "Test Name", "Test Result", true);
            //append row
            addRowToHtmlReport("001", "Login", "Passed", false);
            //append row
            addRowToHtmlReport("002", "Add New Client", "Failed", false);
            //append row
            addRowToHtmlReport("003", "Delete Existing Client", "Passed", false);
            //append row
            addRowToHtmlReport("004", "Logout", "Passed", false);
            //append row
            addRowToHtmlReport("005", "Close Browser", "Failed", false);
            //close html file
            htmlStringReport.append("</table></body></html>");
            //write html string content to a file
            writeToFile(htmlStringReport.toString(), "docs/htmlwritetest.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator + fileName;
        File file = new File(tempFile);
        // if file does exist, then backup and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + fileName + "_backup_");
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();
    }

    public static void addRowToHtmlReport(String testId, String testName, String testResult, boolean isHeader) {
        if (isHeader)
            htmlStringReport.append("<tr><td><b>" + testId + "</b></td><td><b>" + testName + "</b></td><td><b>" + testResult + "</b></td></tr>");
        else {
            if (testResult.toLowerCase().equals("passed"))
                htmlStringReport.append("<tr bgcolor=\"#80ffaa\" ><td><b>" + testId + "</b></td><td><b>" + testName + "</b></td><td><b>" + testResult + "</b></td></tr>");
            else
                htmlStringReport.append("<tr bgcolor=\"#fff0b3\" ><td><b>" + testId + "</b></td><td><b>" + testName + "</b></td><td><b>" + testResult + "</b></td></tr>");

        }
    }

}
