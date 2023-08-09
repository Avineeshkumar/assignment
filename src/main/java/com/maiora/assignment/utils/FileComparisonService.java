package com.maiora.assignment.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class FileComparisonService {
	 public static void main(String[] args) throws IOException {
		 	 
    	 String filePath1 =  "C:\\Users\\avine\\Downloads\\txt1.txt";
         String filePath2 = "C:\\Users\\avine\\Downloads\\txt2.txt";
         	
         XWPFDocument document1 = openDocument(filePath1);
         XWPFDocument document2 = openDocument(filePath2);
         
         List<String> file1Lines = extractLines(document1);
         List<String> file2Lines = extractLines(document2);
                  
         int maxLines = Math.max(file1Lines.size(), file2Lines.size());
                 
         XWPFParagraph documentParagraph1 = document1.createParagraph();
         
         XWPFParagraph documentParagraph2 = document2.createParagraph();
         
         XWPFRun run1 = documentParagraph1.createRun();
         XWPFRun run2 = documentParagraph2.createRun();
                  
         run1.addBreak();
         
         run1.setText("Compare Results");
         run1.setTextHighlightColor("FF0000");
         
         run2.addBreak();
         run2.setText("Compare Results");
         run2.setTextHighlightColor("FF0000");
         
         for (int i = 0; i < maxLines; i++) {
             String line1 = i < file1Lines.size() ? file1Lines.get(i) : "";
             String line2 = i < file2Lines.size() ? file2Lines.get(i) : "";

             run1.addBreak();
             run2.addBreak();
             
             if (!line1.equals(line2)) {
            	 List<String> words1 = List.of(line1.split("\\s+"));
                 List<String> words2 = List.of(line2.split("\\s+"));;

                 int maxWords = Math.max(words1.size(), words2.size());
             
                 for (int j = 0; j < maxWords; j++) {
                     String word1 = j < words1.size() ? words1.get(i) : "";
                     String word2 = j < words2.size() ? words2.get(i) : "";

                     if (!word1.equals(word2)) {
                          
                    	 run1.setTextHighlightColor("FF0000");
                    	 run1.setText(word1);
                                               
                    	 run2.setTextHighlightColor("FF0000");
                         run2.setText(word2);               	 
                    	 
                     } else {
                    	 
                    	 run1.setColor("000000");
                    	 run1.setText(word1);  
                    	 
                    	 run2.setColor("000000");
                         run2.setText(word2);
                        
                        
                     }
                 }
             } else {
            	 run1.setColor("000000");
            	 run1.setText(line1);  
            	 
            	 run2.setColor("000000");
                 run2.setText(line1);
             }
         }
         
         saveDocument(document1,filePath1);
         
         saveDocument(document2,filePath2);
         
     }
    
    private static XWPFDocument openDocument(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        return new XWPFDocument(fis);
    }

    private static List<String> extractLines(XWPFDocument document) {
        List<String> lines = new ArrayList<>();
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            lines.add(paragraph.getText());
        }
        return lines;
    }
    
    
    private static void saveDocument(XWPFDocument document, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            document.write(fos);
        }
    }
}