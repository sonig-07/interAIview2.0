
package com.interai.service;

import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

@Service
public class PDFService {

    public String extractText(String path) throws Exception{

        PDDocument doc = PDDocument.load(new File(path));

        PDFTextStripper stripper = new PDFTextStripper();

        String text = stripper.getText(doc);

        doc.close();

        return text;
    }
}
