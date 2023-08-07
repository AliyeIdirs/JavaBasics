package com.unitedcoder.io;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfFileRead {
    public static void main(String[] args) {
        String projectPath= System.getProperty("user.dir");
        String filePath=projectPath+ File.separator;
        PDDocument pdDocument=null;
        try{
            pdDocument=PDDocument.load(new File(filePath+"docs/ReadingMaterial.pdf"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Total pages: "+getTotalPageCount(pdDocument));
        System.out.println("Text content:\n"+getPdfContent(pdDocument) );
    }
    public static int getTotalPageCount(PDDocument pdDocument){
        return pdDocument.getNumberOfPages();
    }
    public static String getPdfContent(PDDocument pdDocument){
        PDFTextStripper stripper=null;
        String extractedText="";
        try{
            stripper=new PDFTextStripper();
        }catch (IOException e){
            e.printStackTrace();
        }
        stripper.setStartPage(1);
        stripper.setEndPage(pdDocument.getNumberOfPages());
        try{
            extractedText=stripper.getText(pdDocument);
        }catch (IOException e){
            e.printStackTrace();
        }
        return extractedText;
    }
}
