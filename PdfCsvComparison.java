package com.embold.backup;

import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.CompareResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfCsvComparison {

    public static void main(String[] args) {

        String benchmarkFilePath = "src/main/resources/11.pdf";

        if (args.length < 2) {
            System.out.println("Please provide the path to the PDF to compare and the result file path.");
            return;
        }

        // Paths from command-line arguments
        String fileToCompare = args[0];
        String resultFilePath = args[1];

        try {
            // Create temporary files for processed PDFs
            File benchmarkTempFile = createProcessedPdf(new File(benchmarkFilePath));
            File compareTempFile = createProcessedPdf(new File(fileToCompare));

            // Compare the processed PDFs
            CompareResult result = new PdfComparator<>(benchmarkTempFile.getAbsolutePath(), compareTempFile.getAbsolutePath()).compare();

            // Check if the PDFs are identical
            if (result.isEqual()) {
                System.out.println("The PDFs are identical.");
            } else {
                System.out.println("The PDFs are different. Check the differences in: " + resultFilePath);
                result.writeTo(resultFilePath);
            }

            // Clean up: delete temporary files
            benchmarkTempFile.delete();
            compareTempFile.delete();

        } catch (IOException e) {
            System.out.println("An error occurred during PDF comparison: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static File createProcessedPdf(File inputFile) throws IOException {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(inputFile)) {
            // Extract text and perform filtering
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);

            // Split text into lines
            String[] lines = text.split("\n");

            // Create a temporary file for the processed PDF
            File tempFile = File.createTempFile("processed", ".pdf");
            try (PDDocument tempDocument = new PDDocument()) {
                PDPage page = new PDPage();
                tempDocument.addPage(page);

                // Create a content stream for writing to the PDF
                try (PDPageContentStream contentStream = new PDPageContentStream(tempDocument, page)) {
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    float margin = 25;
                    float yStart = page.getMediaBox().getHeight() - margin;
                    float lineHeight = 15f;
                    float yPosition = yStart;

                    contentStream.beginText();
                    contentStream.newLineAtOffset(margin, yPosition);

                    // Write each line of text
                    for (String line : lines) {
                        contentStream.showText(line);
                        contentStream.newLineAtOffset(0, -lineHeight); // Move to the next line
                    }

                    contentStream.endText();
                }

                tempDocument.save(tempFile);
            }

            return tempFile;
        }
    }
}
