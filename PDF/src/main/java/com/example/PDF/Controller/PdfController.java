package com.example.PDF.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.OutputStream;
import java.util.Date;

@RestController
public class PdfController {

    @GetMapping("/generate-pdf")
    public void generatePdf(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");//Tells the browser or Postman: “Hey! I'm sending a PDF file.”
        response.setHeader("Content-Disposition", "attachment; filename=\"hello.pdf\"");//Tells the browser to download the file with the name hello.pdf.

        Document document = new Document();//Creates a new blank PDF document.
        OutputStream out = response.getOutputStream();//Gets the response's output stream so we can write the PDF into it.
        PdfWriter.getInstance(document, out);//Connects the document with the output stream using a PDF writer.
        document.open();//Opens the document — ready to write content.

        document.add(new Paragraph("Hello Muthumari💖"));//add a line of text or paragraph to the pdf
        document.add(new Paragraph("This PDF was generated from a Spring Boot app."));
        document.add(new Paragraph("Date: " + new Date()));//add current date and time

        document.close();//finishing writing - close the document
        out.close();//closing output stream
    }
}