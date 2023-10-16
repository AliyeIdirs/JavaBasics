package regressionsuit.pageelementmodel;

import com.unitedcoder.configutility.ApplicationConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : user
 * @created : 16.10.2023,11:14
 * @Email :aliyeidiris@gmail.com
 **/
public class TestResultGenerator {
    public static StringBuilder htmlTestResultBuilder;

    public static void initializeHtmlTestResult() {
        htmlTestResultBuilder = new StringBuilder();
        htmlTestResultBuilder.append("<html><head><title>Test Result Report</title></head><body>");
        htmlTestResultBuilder.append("<p><b>Test User:</b> " + getCurrentTestUserName()
                + "</p>");
        htmlTestResultBuilder.append("<p><b>Test Host:</b> " + GetCurrentTestHostName()
                + "</p>");
        htmlTestResultBuilder.append("<p><b>Platform Url:</b> " + ApplicationConfig.readConfigProperties("config.properties", "qaurl") + "</p>");
        htmlTestResultBuilder.append("<p><b>Test Start Time:</b> " + getCurrentTimeStamp()
                + "</p>");
        htmlTestResultBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
        String tableHeader = "<tr align=\"center\">" +
                "<td>Test Id</td>" +
                "<td>Test Name</td>" +
                "<td>Action</td" +
                "><td>Expected Result</td>" +
                "<td>Actual Result</td>" +
                "<td>Test Status</td>" +
                "<td>Test Note</td>" +
                "</tr>";
        htmlTestResultBuilder.append(tableHeader);
    }

    public static void appendToHtmlTestResult(String testId, String testName, String Action,
                                              String expectedResult, String actualResult,
                                              boolean testStatus, String testNote) {
        if (testStatus)
            htmlTestResultBuilder
                    .append("<tr><td style=\"background-color:#33CC33\">"
                            + testId + "</td><td>"
                            + testName + "</td><td>"
                            + Action + "</td><td>"
                            + expectedResult + "</td><td>"
                            + actualResult + "</td><td>"
                            + testStatus + "</td><td>"
                            + testNote + "</td>"
                            + "<tr>");
        else
            htmlTestResultBuilder
                    .append("<tr><td style=\"background-color:#FFFF00\">"
                            + testId + "</td><td>"
                            + testName + "</td><td>"
                            + Action + "</td><td>"
                            + expectedResult + "</td><td>"
                            + actualResult + "</td><td>"
                            + testStatus + "</td><td>"
                            + testNote + "</td>"
                            + "<tr>");
    }

    public static void endHTMLTestResult() {
        htmlTestResultBuilder.append("</table>");
        htmlTestResultBuilder.append("<p><b>Test End Time:</b> " + getCurrentTimeStamp() + "</p>");
        htmlTestResultBuilder.append("</body></html>");
    }

    public static String getHtmlTestResultString() {
        return htmlTestResultBuilder.toString();
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss.SSS");// dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        strDate = strDate.replace(':', '-').replace('.', '-');
        return strDate;
    }

    // Get Current User Name
    public static String getCurrentTestUserName() {
        return System.getProperty("user.name");
    }

    // Get Current Host Name
    public static String GetCurrentTestHostName() {
        InetAddress localMachine = null;
        try {
            localMachine = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName = localMachine.getHostName();
        return hostName;
    }

    public static void writeToFile(String fileNamePrefix, String fileName, String fileExtension, String content) {
        String workingDir = System.getProperty("user.dir");
        String logPath = ApplicationConfig.readConfigProperties("config.properties", "reportFolder");
        File filePath = new File(workingDir + File.separator + logPath);
        System.out.println("Log file path : " + filePath.getPath());
        if (!filePath.exists())
            filePath.mkdir();
        FileOutputStream fop = null;
        File file;
        try {

            file = new File(filePath + File.separator + fileNamePrefix + fileName + "-" + getCurrentTimeStamp() + fileExtension);
            fop = new FileOutputStream(file);

            // if file doesn't exist, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println(fileNamePrefix + " Log file creation is done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
