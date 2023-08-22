package regressionsuit.junitframework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestResultUtility {
    public static void writeTestReport(String fileName, String reportContent){
        String filePath=System.getProperty("user.dir")+ File.separator+fileName;
        File file=new File(filePath);
        //create the file
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //create a FileWriter and write content
        FileWriter writer= null;
        try {
            writer = new FileWriter(file);
            writer.write(reportContent);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
