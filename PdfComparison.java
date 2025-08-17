package com.embold.backup;

import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.CompareResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PdfComparison {

    public static void main(String[] args) {

        String benchmarkFilePath = "src/main/resources/11.pdf";

        if (args.length < 2) {
            System.out.println("Please provide the path to the PDF to compare and the result file path.");
            return;
        }
        String parameterFilePath = args[0];
        String resultFilePath = args[1];

        try {

            InputStream benchmarkInputStream = PdfComparison.class.getClassLoader().getResourceAsStream(benchmarkFilePath);
            if (benchmarkInputStream == null) {
                System.out.println("Benchmark PDF not found.");
                return;
            }

            // Write the InputStream to a temporary file
            File benchmarkFile = File.createTempFile("benchmark", ".pdf");
            try (FileOutputStream outputStream = new FileOutputStream(benchmarkFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = benchmarkInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            benchmarkInputStream.close();

            // Create CompareResult for comparison
            CompareResult result = new PdfComparator<>(benchmarkFile.getAbsolutePath(), parameterFilePath).compare();

            // Check if the PDFs are identical
            if (result.isEqual()) {
                System.out.println("The PDFs are identical.");
            } else {
                System.out.println("The PDFs are different. Check the differences in: " + resultFilePath);
                result.writeTo(resultFilePath);
            }

            // Clean up: delete the temporary file
           // benchmarkFile.delete();

        } catch (IOException e) {
            System.out.println("An error occurred during PDF comparison: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
