package Lab11;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        // Create sample files
        Files.write(Paths.get("log1.txt"), Arrays.asList(
            "Java started",
            "Error found",
            "Program running"
        ));

        Files.write(Paths.get("log2.txt"), Arrays.asList(
            "Error occurred",
            "Java completed"
        ));

        String[] files = {"log1.txt", "log2.txt"};

        int totalLines = 0;
        int errorLines = 0;

        for (String file : files) {
            Path path = Paths.get(file);

            List<String> lines = Files.readAllLines(path);

            totalLines += lines.size();

            for (String line : lines) {
                if (line.contains("Error")) {
                    errorLines++;
                }
            }

            System.out.println("File: " + file);
            System.out.println("Size: " +
                Files.size(path) + " bytes");
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing Error: " + errorLines);
    }
}

